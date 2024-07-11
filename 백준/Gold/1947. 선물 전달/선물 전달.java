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
        int n = stoi(br.readLine());
        long[] dp = new long[1_000_001];
        long mod = 1_000_000_000;

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for(int i=3; i<=n; i++){
            dp[i] = (i-1) * (dp[i-2] + dp[i-1]) % mod;
        }

        System.out.println(dp[n]);

    }


}