import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
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

//    private static boolean isArea(int x, int y){
//        return 1<=x && x<=m && 1<=y && y<=n;
//    }

    private static Integer[] r_dp;
    private static Integer[] l_dp;
    private static int[] seq;

    private static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int[][] dp = new int[k+1][n+1];
        Arrays.fill(dp[1],1);

        for(int i=1; i<=k; i++){
            dp[i][0]=1;
        }

        for(int i=2; i<=k; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= MOD;
            }
        }

        System.out.println(dp[k][n]);


    }

}