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
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

//    private static boolean isArea(int x, int y){
//        return 0<=x && x<N && 0<=y && y<N;
//    }

    private static int[][] dp;

    private static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException{

//        st = new StringTokenizer(br.readLine());

        String str1 = br.readLine();
        String str2 = br.readLine();

        LCS(str1, str2);
        getLCSToString(str1, str1.length(), str2.length());

        System.out.println(sb);
    }

    private static void LCS (String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        dp = new int[n1+1][n2+1];
        int max =-1;
        for(int i=1; i<n1+1; i++) {
            for(int j=1; j<n2+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        sb.append(dp[n1][n2]).append("\n");
    }

    private static void getLCSToString(String str1, int i , int j){
        Stack<Character>st = new Stack<>();
        while(i>0 && j>0){
            if(dp[i][j] == dp[i-1][j]){
                i--;
            }
            else if(dp[i][j] == dp[i][j-1]){
                j--;
            }
            else{
                st.push(str1.charAt(i-1));
                i--;
                j--;
            }
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
    }


}