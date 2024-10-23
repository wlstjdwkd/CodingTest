import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

//    private static boolean isArea(int x, int y){
//        return 1<=x && x<=m && 1<=y && y<=n;
//    }

    private static final int MOD = 1000000;

    public static void main(String[] args) throws IOException{

        String str = br.readLine();

        int[] dp = new int[str.length()+1];
        dp[0] = 1;

        for(int i=1; i<=str.length(); i++){
            int now = str.charAt(i-1)-'0';
            if(1<=now && now<=9){
                dp[i] += dp[i-1];
                dp[i] %= MOD;
            }

            if(i==1){
                continue;
            }

            int prev = str.charAt(i-2)-'0';

            if(prev == 0){
                continue;
            }

            int value = prev*10 + now;

            if(10<=value && value<=26){
                dp[i] += dp[i-2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[str.length()]);
    }



}