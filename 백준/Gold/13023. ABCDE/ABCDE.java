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

    private static int N,M;
    private static boolean[] visited;
    private static List<Integer>[] list;
    private static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        list = new ArrayList[N];
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            list[a].add(b);
            list[b].add(a);

        }

        for(int i=0; i<N; i++){
            if(ans == 0){
                dfs(i,1);
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int start, int depth){
        if(depth == 5){
            ans = 1;
            return;
        }

        visited[start] = true;
        for(int i : list[start]){
            if(!visited[i]){
                dfs(i, depth+1);
            }
        }
        visited[start] = false;
    }

}