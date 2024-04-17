import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] list;
    static int N;
    static boolean[] isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for(int i= 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        isCycle = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(checkCycle(i,i,i)){
                break;
            }
            isCycle = new boolean[N+1];
        }

        int[] result = new int[N+1];
        for(int i=1; i<=N; i++){
            if(!isCycle[i]){
                result[i] = bfs(i);
            }
        }
        for(int i=1; i<=N; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int bfs(int node){
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.add(new Node(node, 0));
        while(!q.isEmpty()){
            Node current = q.poll();
            if(isCycle[current.v]){
                return current.count;
            }

            for(int i=0; i<list[current.v].size(); i++){
                int next = list[current.v].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new Node(next, current.count+1));
                }
            }
        }

        return 0;
    }

    private static boolean checkCycle(int prev, int node, int start){
        isCycle[node] = true;
        for(int i=0; i<list[node].size(); i++){
            int next = list[node].get(i);
            if(!isCycle[next]){
                if(checkCycle(node, next, start)){
                    return true;
                }

            }
            else if(next!= prev && next == start){
                return true;
            }
        }
        isCycle[node] = false;

        return false;
    }

    private static class Node{
        int v, count;
        public Node(int v, int count){
            this.v = v;
            this.count = count;
        }
    }
}