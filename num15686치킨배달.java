import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num15686치킨배달 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] map;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static boolean[] open;
    static int result = Integer.MAX_VALUE;

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        person = new ArrayList<>();
        chicken = new ArrayList<>();


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    person.add(new Point(i,j));
                }
                else if(map[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];

        dfs(0,0);
        System.out.println(result);
    }

    //치킨 백트래킹 써야할듯?
    //dfs 할 때 마지막 return을 왜 이렇게 까먹지?
    private static void dfs(int start, int cnt){
        if(cnt == M){
            int res=0;
            for(int i=0; i<person.size(); i++){
                int temp = Integer.MAX_VALUE;

                for(int j=0; j<chicken.size(); j++){
                    if(open[j]){
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x)+ Math.abs(person.get(i).y-chicken.get(j).y);

                        temp = Math.min(temp,distance);
                    }
                }
                res +=temp;
            }

            result = Math.min(result,res);
            return;
        }

        for(int i= start; i<chicken.size(); i++){
            open[i]= true;
            dfs(i+1, cnt+1);
            open[i] = false;
        }
    }
}
