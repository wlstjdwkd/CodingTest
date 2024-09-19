import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<N && 0<=y && y<N;
//    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        PriorityQueue<GasStation> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            pq.add(new GasStation(a, b));
        }

        st = new StringTokenizer(br.readLine());

        int L = stoi(st.nextToken());
        int P = stoi(st.nextToken());

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;
        while(P<L){
            while(!pq.isEmpty() && pq.peek().a <= P){
                pq2.add(pq.poll().b);
            }

            if(pq2.isEmpty()){
                System.out.println(-1);
                return;
            }

            answer++;
            P += pq2.poll();
        }

        System.out.println(answer);
    }

    private static class GasStation implements Comparable<GasStation>{
        int a;
        int b;
        public GasStation(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(GasStation o) {
            return this.a - o.a;
        }
    }



}