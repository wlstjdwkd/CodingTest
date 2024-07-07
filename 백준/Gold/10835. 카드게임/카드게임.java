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
        left = new int[n];
        right = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            left[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            right[i] = stoi(st.nextToken());
        }

        dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(topDown(0,0));
    }

    private static int topDown(int l, int r){
        if(l==n || r==n){
            return 0;
        }

        if(dp[l][r] != -1){
            return dp[l][r];
        }

        dp[l][r] = Math.max(topDown(l+1, r), topDown(l+1, r+1));

        if(left[l] > right[r]){
            dp[l][r] = Math.max(dp[l][r], topDown(l, r+1) + right[r]);
        }

        return dp[l][r];
    }

    private static int[][] dp;
    private static int n;
    private static int[] left;
    private static int[] right;

}