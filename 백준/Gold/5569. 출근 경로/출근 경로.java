import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.*;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<n && 0<=y && y<m;
//    }


    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        st= new StringTokenizer(str);

        final int mod = 100000;

        final int w = stoi(st.nextToken());
        final int h = stoi(st.nextToken());

        int[][][][] dp = new int[w+1][h+1][2][2];
        //방향 0은 오른, 1은 아래
        //0은 꺾지 않은 경우, 1은 꺾은 경우
        for(int i=1; i<=w; i++){
            dp[i][1][0][0] = 1;
        }

        for(int i=1; i<=h; i++){
            dp[1][i][1][0] = 1;
        }

        for(int i=2; i<=w; i++){
            for(int j=2; j<=h; j++){
                dp[i][j][1][0] = (dp[i][j-1][1][1] + dp[i][j-1][1][0]) % mod;
                dp[i][j][1][1] = dp[i][j-1][0][0] % mod;
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % mod;
                dp[i][j][0][1] = dp[i-1][j][1][0] % mod;
            }
        }

        int result = (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % mod;

        System.out.println(result);
    }


}