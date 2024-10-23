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

    private static Integer[] r_dp;
    private static Integer[] l_dp;
    private static int[] seq;

    public static void main(String[] args) throws IOException{

        int N = stoi(br.readLine());

        r_dp = new Integer[N];
        l_dp = new Integer[N];
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            seq[i] = stoi(st.nextToken());
        }

        for(int i=0; i<N; i++){
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for(int i=0; i<N; i++){
            max = Math.max(max, r_dp[i] + l_dp[i]);
        }

        System.out.println(max - 1);

    }

    private static int LIS(int N){
        if(r_dp[N] == null){
            r_dp[N] = 1;

            for(int i= N -1; i>=0; i--){
                if(seq[i] < seq[N]){
                    r_dp[N] = Math.max(r_dp[N], LIS(i) + 1);
                }
            }
        }

        return r_dp[N];
    }

    private static int LDS(int N){
        if(l_dp[N] == null){
            l_dp[N] = 1;

            for(int i= N +1; i< l_dp.length; i++){
                if(seq[i] < seq[N]){
                    l_dp[N] = Math.max(l_dp[N], LDS(i) + 1);
                }
            }
        }

        return l_dp[N];
    }

}