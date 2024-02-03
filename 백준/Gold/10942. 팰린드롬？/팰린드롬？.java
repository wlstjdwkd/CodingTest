import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        dp = new boolean[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr, N);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(dp[s][e]){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static void solve(int[] arr, int n){
        for(int i=1; i<=n; i++){
            dp[i][i] = true;
        }

        for(int i=1; i<=n-1; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }

        for(int i=2; i<n; i++){
            for(int j=1; j<=n-i; j++){
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]){
                    dp[j][j+i] = true;
                }
            }
        }
    }
}