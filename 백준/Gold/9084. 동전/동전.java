import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <=M; k++) {
                    if (k - arr[j] > 0) {
                        dp[k] = dp[k] + dp[k-arr[j]];
                    } else if (k - arr[j] == 0) {
                        dp[k]++;
                    }
                }
            }
            sb.append(dp[M] + "\n");
        }
        System.out.println(sb);
    }
}