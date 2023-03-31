import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, arr[], dp[];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];

        int result = dp[1];
        for(int i=2; i<=N; i++){
            dp[i]=arr[i];
            for(int j=1; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                }
            }
            result = Math.max(result,dp[i]);
        }

        System.out.println(result);
    }
}