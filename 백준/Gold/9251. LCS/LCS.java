import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

//    private static boolean isArea(int x, int y){
//        return 0<=x && x<r && 0<=y && y<c;
//    }

    private static char[] str1;
    private static char[] str2;

    private static Integer[][] dp;

    public static void main(String[] args) throws IOException{

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new Integer[str1.length][str2.length];

        System.out.println(LCS(str1.length-1, str2.length-1));
    }

    private static int LCS(int x, int y){
        if(x== -1 || y == -1){
            return 0;
        }

        if(dp[x][y] == null){
            dp[x][y] = 0;

            if(str1[x] == str2[y]){
                dp[x][y] = LCS(x-1,y-1) + 1;
            }

            else{
                dp[x][y] = Math.max(LCS(x-1,y), LCS(x,y-1));
            }
        }

        return dp[x][y];
    }



}