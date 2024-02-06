import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n==1 && m==1){
            System.out.println(1);
            return;
        }
        int ans = 0;

        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            String[] input = br.readLine().split("");
            for(int j=1; j<=m; j++){
                int temp = Integer.parseInt(input[j-1]);
                if(i==1 && j==1){
                    dp[i][j] = temp;
                }
                else{
                    if(temp==1){
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(ans*ans);
    }
}