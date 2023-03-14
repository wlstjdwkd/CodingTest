import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K;
    static int[] distance = new int[100001];
    static PriorityQueue<Point> pq =new PriorityQueue<>();
    static class Point implements Comparable<Point>{
        int loc,cost;

        public Point(int loc, int cost) {
            this.loc = loc;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point that){
            return this.cost-that.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(distance,Integer.MAX_VALUE);
        find();
        System.out.println(distance[K]);

    }
    private static void find(){
        pq.add(new Point(N,0));
        distance[N] =0;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            int nloc, ncost;

            nloc = p.loc+1;
            ncost = p.cost+1;
            if(nloc<=100000 && ncost<distance[nloc]){
                distance[nloc] = ncost;
                pq.add(new Point(nloc,ncost));
            }

            nloc = p.loc-1;
            ncost = p.cost+1;
            if(0<=nloc && ncost<distance[nloc]){
                distance[nloc] = ncost;
                pq.add(new Point(nloc,ncost));
            }

            nloc = p.loc*2;
            ncost = p.cost;
            if(nloc<=100000 && ncost<distance[nloc]){
                distance[nloc] = ncost;
                pq.add(new Point(nloc,ncost));
            }

        }
    }

}