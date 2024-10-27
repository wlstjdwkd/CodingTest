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


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int ans = Integer.MAX_VALUE;

        int[] memoryArr = new int[n];
        int[] costArr = new int[n];
        int[][] dp = new int[n][10001];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            memoryArr[i] = stoi(st.nextToken());
            costArr[i] = stoi(st2.nextToken());
        }

        for(int i=0; i<n; i++){
            int cost = costArr[i];
            int memory = memoryArr[i];

            for(int j=0; j<=10000; j++){
                if(i==0){
                    if(j>=cost){
                        dp[i][j] = memory;
                    }
                }
                else{
                    if(j>=cost){
                        dp[i][j] = Math.max(dp[i-1][j-cost] + memory, dp[i-1][j]);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }

                    
                }

                if(dp[i][j]>=m){
                    ans = Math.min(ans, j);
                }
            }
        }

        System.out.println(ans);
    }


}