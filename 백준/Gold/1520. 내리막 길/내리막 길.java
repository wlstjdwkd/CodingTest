import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx ={0,-1,1,0};
    static int[] dy = {1,0,0,-1};
    static int[][] arr;
    static int[][] dp;
    static int M,N,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        dp = new int[M][N];

        answer=0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }


        System.out.println(dfs(0,0));

    }
    public static int dfs(int x,int y){
        if(x==N-1 && y==M-1){
            return 1;
        }
        if(dp[y][x]!=-1){
            return dp[y][x];
        }
        dp[y][x]=0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int score=arr[y][x];

            if(isInArea(nx,ny)){
                if(score>arr[ny][nx]){

                    dp[y][x]+=dfs(nx,ny);
                }
            }
        }


        return dp[y][x];

    }
    public static boolean isInArea(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
}