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



//    private static boolean isArea(int x, int y){
//        return 1<=x && x<=N && 1<=y && y<=N;
//    }

    private static int n;
    private static boolean[] visited;
    private static List<Integer>[] graph;

    private static int[][] dp;


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int number){
        visited[number] = true;
        dp[number][0] = 0;
        dp[number][1] = 1;

        for(int child : graph[number]){
            if(!visited[child]){
                dfs(child);
                dp[number][0] += dp[child][1];
                dp[number][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }


}