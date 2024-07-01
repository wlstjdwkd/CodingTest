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
        int n = stoi(st.nextToken());
        int money = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int[] cal = new int[n];
            int[] cost = new int[money];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                cal[i] = stoi(st.nextToken());
                cost[i] = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
            }

            int[] dp = new int[money + 1];
            for(int i=0; i<n; i++){
                for(int j=0; j<money+1; j++){
                    int remainedMoney = j - cost[i];
                    if(0<= remainedMoney){
                        dp[j] = Math.max(dp[j], dp[remainedMoney] + cal[i]);
                    }
                }
            }

            sb.append(dp[money]).append("\n");

            st = new StringTokenizer(br.readLine());
            n = stoi(st.nextToken());
            money = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
        }

        System.out.println(sb);
    }


}