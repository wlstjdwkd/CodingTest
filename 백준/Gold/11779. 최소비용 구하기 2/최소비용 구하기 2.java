import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb= new StringBuilder();
    static int n,m;
    static int[] dist;
    static int[] precity;
    static int start2,end2;
    static List<ArrayList<City>> graph = new ArrayList<>();
    static class City implements Comparable<City>{
        int end, value;

        public City(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(City c){
            return this.value-c.value;
        }
    }
    public static void main(String[] args) throws IOException {
        n= Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        precity = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(start).add(new City(end,value));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start2 = Integer.parseInt(st.nextToken());
        end2 = Integer.parseInt(st.nextToken());
        dijkstra(start2);
        sb.append(dist[end2]).append("\n");
        int cnt=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(end2);
        while(precity[end2]!=0){
            cnt+=1;
            stack.push(precity[end2]);
            end2 = precity[end2];
        }
        sb.append(cnt+1).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
    private static void dijkstra(int start){
        PriorityQueue<City> pq =new PriorityQueue<>();
        pq.add(new City(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            City curCity = pq.poll();
            int cur = curCity.end;
            if(dist[cur]<curCity.value){
                continue;
            }
            for(City next : graph.get(cur)){
                if(dist[next.end] > dist[cur]+next.value){
                    dist[next.end] = dist[cur]+next.value;
                    precity[next.end] = cur;
                    pq.add(new City(next.end, dist[next.end]));
                }
            }
        }
    }
}