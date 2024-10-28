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

        int N = stoi(st.nextToken());

        int[][] arr = new int[N+2][2];
        int[] dp = new int[N+2];

        for(int i= 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = stoi(st.nextToken());
            arr[i][1] = stoi(st.nextToken());
        }

        int max = -1;
        for(int i=1; i<=N+1; i++){
            if(max < dp[i]){
                max = dp[i];
            }

            int nxt = i + arr[i][0];
            if(nxt<N+2){
                dp[nxt] = Math.max(dp[nxt], max + arr[i][1]);
            }
        }

        System.out.println(dp[N+1]);
    }


}