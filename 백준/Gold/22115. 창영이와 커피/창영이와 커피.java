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

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        st= new StringTokenizer(br.readLine());

        int[] coffee = new int[N];
        for(int i=0;i<N;i++){
            coffee[i] = stoi(st.nextToken());
        }

        int[] dp = new int[K+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;


        for(int i=0;i<N; i++){
            int cof = coffee[i];
            for(int j=K; j>=cof; j--){
                if(dp[j-cof] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-cof]+1);
                }
            }
        }


        if(dp[K] == Integer.MAX_VALUE){
            dp[K] = -1;
        }
        System.out.println(dp[K]);


    }

}