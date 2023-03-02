import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weight;
    public Node(int end, int weight){
        this.end =end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return weight-o.weight;
    }
}
public class Main {
    static int V,E,K;
    static List<Node>[] list;
    static int[] dist;
    private static final int INF = 100_000_000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        dist = new int[V+1];

        Arrays.fill(dist,INF);

        for(int i=1; i<=V;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(K);
        for(int i=1; i<=V; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(check[cur] == true) continue;
            check[cur] = true;

            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
