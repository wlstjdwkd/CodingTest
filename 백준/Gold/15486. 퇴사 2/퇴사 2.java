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
        int[][] arr = new int[n+2][2];
        int[] dp = new int[n+2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            int t = stoi(st.nextToken());
            int p = stoi(st.nextToken());
            arr[i][0] = t;
            arr[i][1] = p;
        }

        int max = -1;
        for(int i=1; i<=n+1; i++){
            if(max < dp[i]){
                max = dp[i];
            }

            int nxt = i + arr[i][0];
            if(nxt < n+2){
                dp[nxt] = Math.max(dp[nxt], max + arr[i][1]);
            }
        }

        System.out.println(dp[n+1]);
    }
}