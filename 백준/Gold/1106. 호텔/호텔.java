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
        st = new StringTokenizer(br.readLine());

        c = stoi(st.nextToken());
        n = stoi(st.nextToken());

        dp = new int[c+101];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = stoi(st.nextToken());
            int people = stoi(st.nextToken());
            for(int j= people; j< c+101; j++){
                dp[j] = Math.min(dp[j], cost +dp[j-people]);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=c; i<c+101; i++){
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }

    private static int c,n;
    private static int[] dp;

}