import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static char[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Point> teacher = new ArrayList<>();
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = st.nextToken().charAt(0);
                if(arr[i][j]=='T'){
                    teacher.add(new Point(i,j));
                }
            }
        }
        dfs(0);
        System.out.println("NO");
    }

    private static void dfs(int cnt){
        if(cnt==3){
            if(check()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]=='X'){
                    arr[i][j]='O';
                    dfs(cnt+1);
                    arr[i][j]='X';
                }
            }
        }
    }

    private static boolean check(){
        for(int i=0; i<teacher.size(); i++){
            Point p = teacher.get(i);
            for(int j=0; j<4; j++){
                int xx = p.x;
                int yy = p.y;

                while(true){ //쭉 직진
                    xx += dx[j];
                    yy += dy[j];

                    if(xx<0 || yy<0 || xx>=N || yy>=N){
                        //직진하다가 벽만나버림
                        break;
                    }

                    if(arr[xx][yy]=='O'){
                        //중간에 장애물 만나버림
                        break;
                    }

                    if(arr[xx][yy]=='S'){
                        //학생만나버려서 탈출 대실패
                        return false;
                    }
                }
            }
        }
        return true;
    }
}