import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K,L;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static HashMap<Integer, String> hash = new HashMap<>();
    static List<int[]>snake = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            //사과
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            arr[a][b]=1;
        }

        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            //방향 변환
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            hash.put(X,C);
        }
        play();

    }
    private static void play(){
        int x=0, y=0;
        int time=0;
        int i=0;
        snake.add(new int[]{0, 0});
        while(true){
            time++;

            int nx = x+ dx[i];
            int ny = y +dy[i];

            if(isFinish(nx,ny)){
                break;
            }
            if(arr[nx][ny]==1){
                arr[nx][ny]=0;
                snake.add(new int[]{nx,ny});
            }
            else{
                snake.add(new int[]{nx,ny});
                snake.remove(0);
            }

            //방향 바꿀시간
            if(hash.containsKey(time)){
                if (hash.get(time).equals("D")) {//오른쪽
                    i += 1;
                    if (i == 4)
                        i = 0;
                } else {//L   왼쪽
                    i -= 1;
                    if (i == -1)
                        i = 3;
                }
            }
            x=nx;
            y=ny;
        }
        System.out.println(time);
    }
    private static boolean isFinish(int x, int y){
        if(x<0 ||y<0||x>=N || y>=N){
            //벽
            return true;
        }

        for(int i=0; i<snake.size(); i++){
            //머리가 몸통 마즘
            int[] t = snake.get(i);
            if (x == t[0] && y == t[1])
                return true;
        }
        return false;
    }
}