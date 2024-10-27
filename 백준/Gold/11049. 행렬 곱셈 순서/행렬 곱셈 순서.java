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
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static int n, INF = Integer.MAX_VALUE;
    private static int[] data;
    private static int[][] dp;

//    private static boolean isArea(int x, int y){
//        return 1<=x && x<=N && 1<=y && y<=N;
//    }


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        data = new int[N+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int r = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            data[i] = r;
            data[i+1] = c;
        }

        dp = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], INF);
        }
        System.out.println(solve(0,N-1));
    }

    private static int solve(int pos, int cur){
        if(pos == cur){
            return 0;
        }

        if(dp[pos][cur] != INF) return dp[pos][cur];

        for(int i= pos; i<cur; i++){
            int value = solve(pos, i) + solve(i+1, cur) +data[pos] * data[i+1] * data[cur+1];
            dp[pos][cur] = Math.min(value, dp[pos][cur]);
        }

        return dp[pos][cur];
    }


}