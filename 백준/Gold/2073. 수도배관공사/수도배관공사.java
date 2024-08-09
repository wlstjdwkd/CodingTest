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
        int m = stoi(st.nextToken());

        int[][] arr = new int[m][2];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = stoi(st.nextToken());
            arr[i][1] = stoi(st.nextToken());
        }

        int[] dp = new int[n+1];

        dp[0] = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=n; j>=arr[i][0]; j--){
                dp[j] = Math.max(dp[j], Math.min(dp[j-arr[i][0]], arr[i][1]));
            }
        }

        System.out.println(dp[n]);
    }

}