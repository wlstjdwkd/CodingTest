import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }//input

        dfs(1);

        //print
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }//end of main

    private static void dfs(int v) {
        visited[v]=true;

        for(int vertex: list[v]) {
            if(!visited[vertex]) {
                parents[vertex]=v;
                dfs(vertex);
            }
        }
    }
}
