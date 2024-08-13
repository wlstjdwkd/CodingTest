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
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                String s = st.nextToken();
                if(s.charAt(0) == 'A'){
                    apple[i][j] = stoi(s.substring(1));
                }
                else{
                    banana[i][j] = stoi(s.substring(1));
                }
            }
        }

        applePrefixSum();
        bananaPrefixSum();
        totalPrefixSum();
        findMaxSum();
        System.out.println(dp[N-1][M-1]);
    }

    private static void findMaxSum(){
        for(int i=0; i<N; i++){
            dp[i][0] = total[i][0];
        }

        for(int j=1; j<M; j++){
            for(int i=0; i<N; i++){
                if(i==0){
                    dp[i][j] = dp[i][j-1] + total[i][j];
                }
                else{
                    dp[i][j] = Math.max(Math.max(dp[i][j-1] + total[i][j], dp[i-1][j-1] + total[i][j]), dp[i-1][j] - apple[i][j]);
                }
            }
        }
    }

    private static void applePrefixSum(){
        for(int j=0; j<M; j++){
            for(int i=N-1; i>0; i--){
                appleSum[i-1][j] = appleSum[i][j] + apple[i][j];
            }
        }
    }

    private static void bananaPrefixSum(){
        for(int j=1; j<M; j++){
            for(int i=0; i<N; i++){
                bananaSum[i+1][j] = bananaSum[i][j] + banana[i][j];
            }
        }
    }

    private static void totalPrefixSum(){
        for(int i = 0; i<N; i++){
            for(int j=0; j<M; j++){
                total[i][j] =appleSum[i][j] + bananaSum[i][j];
            }
        }
    }

    private static int[][] appleSum = new int[1501][1501];
    private static int[][] apple = new int[1501][1501];
    private static int[][] bananaSum = new int[1501][1501];
    private static int[][] banana = new int[1501][1501];
    private static int[][] total = new int[1501][1501];
    private static int[][] dp = new int[1501][1501];
    private static int N,M;



}