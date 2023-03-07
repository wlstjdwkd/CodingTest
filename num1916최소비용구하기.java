import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num1916최소비용구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int start, target;
    static int[] d = new int[1001];
    static class Node implements Comparable<Node>{
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        private int getIndex(){
            return this.index;
        }
        private int getDistance(){
            return this.distance;
        }

        @Override
        public int compareTo(Node o){
            if(this.distance < o.distance){
                return -1;
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        Arrays.fill(d,Integer.MAX_VALUE);
        dijkstra();
        System.out.println(d[target]);

    }
    private static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start,0));
        d[start]=0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if(d[now]<dist){
                continue;
            }
            for(int i=0; i<graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).distance;

                if(cost < d[graph.get(now).get(i).index]){
                    d[graph.get(now).get(i).index]=cost;
                    pq.add(new Node(graph.get(now).get(i).index,cost));
                }
            }
        }
    }

}
