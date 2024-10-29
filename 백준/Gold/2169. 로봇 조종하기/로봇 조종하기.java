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
        int M = stoi(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] dp = new int[N+1][M+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = stoi(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        for(int i=1; i<M; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }

        int[][] temp = new int[2][M];

        for(int i=1; i<N; i++){

            temp[0][0] = dp[i-1][0] + arr[i][0];
            for(int j=1; j<M; j++){

                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + arr[i][j];
            }

            temp[1][M-1] = dp[i-1][M-1] + arr[i][M-1];

            for(int j=M-2; j>=0; j--){
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + arr[i][j];
            }

            for(int j=0; j<M; j++){
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }



}