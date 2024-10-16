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
        int m = stoi(st.nextToken());
        int k = stoi(st.nextToken());

        parents = new int[2][n+1];
        Arrays.fill(parents[0], -1);
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            parents[1][i] = stoi(st.nextToken());
        }

        List<Integer>[] edges = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            edges[i] = new ArrayList<>();
        }

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            union(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        List<int[]> group = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(i != find(i)){
                continue;
            }

            group.add(new int[]{-parents[0][i], parents[1][i]});
        }

        int[] dp = new int[k];

        for(int[] each : group){
            int a = each[0];
            int b = each[1];
            for(int i= k-1; i>=a; i--){
                dp[i] = Math.max(dp[i], dp[i-a]+b);
            }
        }

        System.out.println(dp[k-1]);

    }

}