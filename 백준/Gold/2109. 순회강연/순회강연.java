import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static class Point implements Comparable<Point>{
        int p,d;

        public Point(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Point p){
            if(p.p != this.p){
                return p.p - this.p;
            }
            else{
                return this.d-p.d;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new Point(p,d));
        }

        boolean[] check = new boolean[10001];
        int result=0;
        while(!pq.isEmpty()){
            Point p = pq.poll();

            for(int i=p.d; i>0; i--){
                if(!check[i]){
                    check[i] = true;
                    result+=p.p;
                    break;
                }
            }
        }
        System.out.println(result);

    }
}