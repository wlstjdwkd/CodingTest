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

        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=30; i++){
            long cnt = 0;
            for(int j=0; j<i; j++){
                cnt += dp[j] * dp[i-j-1];
            }
            dp[i] = cnt;
        }

        while(true){
            int N = stoi(br.readLine());

            if(N ==0){
                break;
            }
            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }

}