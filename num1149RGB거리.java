import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1149RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[][] dp = new int [a+1][3];
        for(int i=1; i<=a; i++){
            String s= br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B;
        }

        System.out.println(Math.min(dp[a][0],Math.min(dp[a][1],dp[a][2])));
    }
}
