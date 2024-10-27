import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }



//    private static boolean isArea(int x, int y){
//        return 1<=x && x<=N && 1<=y && y<=N;
//    }
    private static int[] novel;
    private static int[][] dp;
    private static int[] sum;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int T = stoi(st.nextToken());
        while(T-->0){
            int K = stoi(br.readLine());
            st = new StringTokenizer(br.readLine());
            novel = new int[K+1];
            dp = new int[K+1][K+1];
            sum = new int[K+1];

            for(int i=0; i<K+1; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for(int i=1; i<=K; i++){
                novel[i] = stoi(st.nextToken());
                sum[i] = sum[i-1] + novel[i];
            }

            sb.append(solve(1, K)).append('\n');

        }
        System.out.println(sb);
    }

    private static int solve(int prev, int last){
        if(prev == last){
            return 0;
        }
        if(dp[prev][last] != Integer.MAX_VALUE){
            return dp[prev][last];
        }

        for(int i=prev; i<last; i++){
            int value = solve(prev, i) + solve(i+1, last) + sum[last] - sum[prev-1];
            dp[prev][last] = Math.min(dp[prev][last], value);
        }

        return dp[prev][last];
    }


}