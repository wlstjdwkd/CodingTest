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

    private static boolean[][] dp;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int[] arr = new int[n+1];
        dp = new boolean[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = stoi(st.nextToken());
        }

        solve(arr,n);
        int m = stoi(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            if(dp[end][start]){
                sb.append("1\n");
            }
            else{
                sb.append("0\n");
            }
        }

        System.out.println(sb);

    }

    private static void solve(int[] arr, int n){
        for(int i=1; i<=n; i++){
            dp[i][i] = true;
        }

        for(int i=1; i<n; i++){
            if(arr[i] == arr[i+1]){
                dp[i+1][i] = true;
            }
        }

        for(int i=3; i<=n; i++){
            for(int j=1; j<=n-2; j++){
                if(dp[i-1][j+1] && arr[i] == arr[j]){
                    dp[i][j] = true;
                }
            }
        }
    }



}