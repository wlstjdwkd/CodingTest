import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M,result, arr[][], dp[][];
    static boolean visited[][];
    static boolean flag;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                if(s.charAt(j) == 'H'){
                    arr[i][j] = 10;
                }
                else{
                    arr[i][j] = s.charAt(j) - 48;
                }
            }
        }

        visited[0][0] = true;
        flag=false;
        dfs(0,0,1);

        if(flag==true){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }

    }
    private static void dfs(int x, int y, int cnt){
        if(cnt>result){
            result = cnt;
        }
        dp[y][x] = cnt;
        for(int i=0; i<4; i++){
            int num = arr[y][x];
            int xx = x+ num*dx[i];
            int yy = y + num * dy[i];

            if(isInArea(xx,yy)){
                if(arr[yy][xx] == 10){
                    continue;
                }
                if(visited[yy][xx]){
                    flag = true;
                    return;
                }
                if(dp[yy][xx]<=cnt){
                    visited[yy][xx] = true;
                    dfs(xx,yy,cnt+1);
                    visited[yy][xx] = false;
                }
            }
        }
    }

    private static boolean isInArea(int x, int y){
        return 0<=x && x<M && 0<=y && y<N;
    }
}