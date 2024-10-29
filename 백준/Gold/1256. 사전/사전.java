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

    private static final int[] dx = {0,1,0,-1};
    private static final int[] dy = {-1,0,1,0};

//    private static boolean isArea(int x, int y){
//        return 0<=x && x<m && 0<=y && y<n;
//    }




    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        long k = stoi(st.nextToken());
        long[][] dp = new long[202][202];

        for(int i=0; i<=200; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }

        for(int i=1; i<=200; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];

                if(dp[i][j] > 1_000_000_000){
                    dp[i][j] = 1_000_000_001;
                }
            }
        }

        if(dp[m+n][n] < k){
            System.out.println(-1);
            return;
        }

        while(!(n==0 && m==0)){
            if(dp[m+n-1][m] >=k){
                sb.append("a");
                n--;
            }
            else{
                sb.append("z");
                k = k - dp[m+n-1][m];
                m--;
            }
        }

        System.out.println(sb);

    }



}