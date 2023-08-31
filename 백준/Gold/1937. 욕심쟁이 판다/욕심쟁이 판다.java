import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;
    private static int[][] dp;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans, DFS(i,j));
            }
        }
        System.out.println(ans);

    }

    private static int DFS(int x, int y) {
        if(dp[x][y]!=0){
            return dp[x][y];
        }

        dp[x][y]=1;

        int nx,ny;
        for(int i=0; i<4; i++){
            nx = x+ dx[i];
            ny = y+ dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if(map[x][y] < map[nx][ny]){
                dp[x][y] = Math.max(dp[x][y], DFS(nx,ny)+1);
            }
        }
        return dp[x][y];
    }
}