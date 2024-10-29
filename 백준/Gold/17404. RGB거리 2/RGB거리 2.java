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

        int N = stoi(st.nextToken());
        int[][] arr = new int[N+1][3];
        int[][] dp = new int[N+1][3];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = stoi(st.nextToken());
            }
        }

        final int INF = 1_000 * 1_000;

        int min = INF;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i == j){
                    dp[1][j] = arr[1][j];
                }
                else{
                    dp[1][j] = INF;
                }
            }

            for(int j=2; j<=N; j++){
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + arr[j][2];
            }

            for(int j=0; j<3; j++){
                if(i!=j){
                    min = Math.min(min, dp[N][j]);
                }
            }
        }
        System.out.println(min);

    }



}