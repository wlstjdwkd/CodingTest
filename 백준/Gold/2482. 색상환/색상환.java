import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        n = stoi(br.readLine());
        k = stoi(br.readLine());

        dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for(int i=3; i<=n; i++){
            for(int j=2; j<= (i+1)/2; j++){
                dp[i][j] = (dp[i-1][j] +dp[i-2][j-1]) % MOD;
            }
        }

        System.out.println((dp[n-3][k-1] + dp[n-1][k]) % MOD);
//        System.out.println(dp[n][k]);


    }

    private static int n,k;
    private static int[][] dp;
    private static final int MOD = 1_000_000_003;

}