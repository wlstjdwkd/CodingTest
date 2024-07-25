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
        t = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            n = stoi(br.readLine());
            arr = new int[n+1];
            dp = new int[n+1][10001];

            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[j] = stoi(st.nextToken());
                dp[j][arr[j]]++;
            }
            target = stoi(br.readLine());

            makeAnswer();

            sb.append(dp[n][target]).append("\n");

        }
        System.out.println(sb);
    }

    private static void makeAnswer(){
        for(int j=1; j<=n; j++){
            for(int q=1; q<=target; q++){
                if(q-arr[j] <0){
                    dp[j][q] = dp[j-1][q];

                }
                else{
                    dp[j][q] += dp[j-1][q] + dp[j][q-arr[j]];
                }
            }
        }
    }

    private static int t,n;
    private static int target;
    private static int[] arr;
    private static int[][] dp;


}