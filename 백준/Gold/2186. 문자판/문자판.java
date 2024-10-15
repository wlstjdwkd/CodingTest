import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static int n,m,k;
    private static long ans = 0;
    private static char[][] board;
    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};
    private static int[][][] dp;
    private static String answer;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        k = stoi(st.nextToken());

        board = new char[n][m];

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = input.charAt(j);
            }
        }

        answer = br.readLine();

        dp = new int[n][m][answer.length()];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        long cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == answer.charAt(0)){
                    cnt += DFS(i,j,0);
                }
            }
        }

        System.out.println(cnt);

    }

    private static int DFS(int x, int y, int L){
        if(dp[x][y][L] != -1) return dp[x][y][L];
        if(L == answer.length()-1) return dp[x][y][L] = 1;

        dp[x][y][L] = 0;

        for(int i=1; i<=k; i++){
            for(int j=0; j<4; j++){
                int nx = x + dx[j] * i;
                int ny = y + dy[j] * i;

                if(isArea(nx,ny)){
                    if(board[nx][ny] == answer.charAt(L+1)){
                        dp[x][y][L] += DFS(nx, ny, L+1);
                    }
                }

            }
        }

        return dp[x][y][L];
    }

    private static boolean isArea(int x, int y){
        return 0<=x && x<n && 0<= y && y<m;
    }

}