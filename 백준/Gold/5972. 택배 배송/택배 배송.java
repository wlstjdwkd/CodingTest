import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] dist;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,w));
            list[b].add(new Node(a,w));
        }

        Arrays.fill(dist, 50000001);
        dijkstra();
        System.out.println(dist[N]);

    }
    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(!visited[now.x]){
                visited[now.x] = true;
                for(Node next : list[now.x]){
                    if(dist[next.x] > dist[now.x] + next.w){
                        dist[next.x] = dist[now.x] + next.w;
                        pq.offer(new Node(next.x, dist[next.x]));
                    }
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int x, w;

        public Node(int x, int w){
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}