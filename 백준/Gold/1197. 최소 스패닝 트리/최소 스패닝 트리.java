import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point>{
        int to,value;

        public Point(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Point p){
            return this.value - p.value;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int min;
    static int V,E;
    static boolean[] visit;
    static List<Point>[] list;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        visit = new boolean[V+1];
        for(int i=1; i<=V;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[A].add(new Point(B,weight));
            list[B].add(new Point(A,weight));

        }
        prim(1);
        System.out.println(min);

    }
    static void prim(int start) {
        Queue<Point> pq = new PriorityQueue<>();

        pq.add(new Point(start,0));
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            int node = p.to;
            int weight = p.value;

            if(visit[node]) continue;
            // 선택한 간선의 정점으로부터 가장 낮은 가중치 갖는 정점 선택
            visit[node]= true;
            min += weight;

            for(Point next : list[node]) {
                if(!visit[next.to]) {
                    pq.add(next);
                }
            }
        }

    }
}