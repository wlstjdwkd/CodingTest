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

    static int N,M, question, max = 15000, arr[];
    static boolean dp[][];

    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());
        arr = new int[N+1];
        dp = new boolean[31][max+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = stoi(st.nextToken());
        }

        find_dp(0,0);

        StringBuilder sb = new StringBuilder();

        M = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            question = stoi(st.nextToken());

            if(question > 15000){
                sb.append("N ");
            }
            else{
                sb.append(dp[N][question] ? "Y ": "N ");
            }
        }
        System.out.println(sb);
    }

    private static void find_dp(int idx, int weight){
        if(dp[idx][weight]){
            return;
        }

        dp[idx][weight] = true;

        if(idx == N){
            return;
        }

        find_dp(idx+1, weight+arr[idx+1]);
        find_dp(idx+1, weight);
        find_dp(idx+1, Math.abs(weight-arr[idx+1]));

    }

}