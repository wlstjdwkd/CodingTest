import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<n && 0<=y && y<n;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int x = stoi(st.nextToken());
        int[] arr = new int[n];
        dp = new boolean[k+1][x*k+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            arr[i] = a;
        }

        for(int p : arr){
            knapsack(p,k,x);
        }

        int ans = 0;
        for(int i = 0; i<=x*k; i++){
            if(dp[k][i]){
                ans = Math.max(ans, i*(x*k-i));
            }
        }

        System.out.println(ans);

    }

    private static void knapsack(int p, int k, int x){
        for(int i=k-1; i>=1; i--){
            for(int j = x*k; j>=p; j--){
                dp[i+1][j] = dp[i+1][j] || dp[i][j-p];
            }
        }

        dp[1][p] = true;
    }

    private static boolean[][] dp;

}