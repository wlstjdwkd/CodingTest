import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

    private static boolean isArea(int x, int y){
        return 1<=x && x<=m && 1<=y && y<=n;
    }

    private static int n,m;
    private static int[][] dp;
    private static int[][] map;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        m = stoi(st.nextToken());
        n = stoi(st.nextToken());

        map = new int[m+1][n+1];
        dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = stoi(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1,1));

    }

    private static int dfs(int x, int y){
        if(x == m && y == n){
            return 1;
        }

        if(dp[x][y] != -1){
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isArea(nx, ny)){
                if(map[x][y] > map[nx][ny]){
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];
    }



}