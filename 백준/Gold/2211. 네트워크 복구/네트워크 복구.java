import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Network>>list = new ArrayList<>();
    static int N,M,K;
    static int[] dist, path;
    static class Network implements Comparable<Network>{
        int to, value;

        public Network(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Network n){
            return this.value - n.value;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        path = new int [N+1] ;
        dist[1]=0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.get(start).add(new Network(end,value));
            list.get(end).add(new Network(start,value));
        }

        dijkstra();

        StringBuilder sb2 = new StringBuilder();
        for(int i=2; i<=N; i++){
            if(path[i]!=0){
                K++;
                sb2.append(i).append(" ").append(path[i]).append("\n");
            }
        }
        sb.append(K).append("\n").append(sb2);
        System.out.println(sb);

    }
    private static void dijkstra(){
        PriorityQueue<Network> pq = new PriorityQueue<>();
        pq.add(new Network(1,0));
        while(!pq.isEmpty()){
            Network n = pq.poll();

            int cur = n.to;
            if(n.value>dist[cur]) continue;

            for(Network next : list.get(cur)){
                if(dist[next.to] > dist[cur] + next.value){
                    dist[next.to] = dist[cur] + next.value;
                    path[next.to] = cur;
                    pq.add(new Network(next.to,dist[next.to]));
                }
            }
        }
    }


}