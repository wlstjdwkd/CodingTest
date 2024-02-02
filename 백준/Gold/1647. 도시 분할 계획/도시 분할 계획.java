import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int start;
        int to;
        int weight;
        public Edge(int start, int to, int weight){
            this.start = start;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;
    static ArrayList<Edge> edgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(a, b, c));
        }

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int ans = 0;
        int bigCost = 0;
        for(int i=0; i<edgeList.size(); i++){
            Edge edge = edgeList.get(i);

            if(find(edge.start) != find(edge.to)){
                ans += edge.weight;
                union(edge.start, edge.to);

                bigCost = edge.weight;
            }
        }

        System.out.println(ans - bigCost);
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }
}