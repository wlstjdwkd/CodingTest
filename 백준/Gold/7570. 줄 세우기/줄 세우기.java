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

    private static int[][] parents;

    private static int find(int a){
        if(parents[0][a] <0){
            return a;
        }
        return parents[0][a] = find(parents[0][a]);
    }


    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b){
            return;
        }

        int hi = parents[0][a] < parents[0][b] ? a : b;
        int lo = parents[0][a] < parents[0][b] ? b : a;

        parents[0][hi] += parents[0][lo];
        parents[1][hi] += parents[1][lo];
        parents[0][lo] = hi;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int k = stoi(st.nextToken());
            dp[k] = dp[k-1] + 1;
        }

        Arrays.sort(dp);
        System.out.println(n-dp[n]);

    }

}