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
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int L = stoi(st.nextToken());

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int e = stoi(st.nextToken());
            pq.offer(new Info(s, e));
        }

        int result = 0;
        int fill = 0;

        while(!pq.isEmpty()){
            Info cur = pq.poll();
            if(cur.e < fill){
                continue;
            }

            if(fill < cur.s){
                fill = cur.s;
            }

            int remain = (cur.e - fill) % L;
            result += (cur.e - fill) / L;
            fill = cur.e;
            if(remain!= 0){
                result++;
                fill += L - remain;
            }
        }

        System.out.println(result);
    }

    private static class Info implements Comparable<Info>{
        int s, e;
        public Info(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Info o) {
            if(this.s == o.s){
                return o.e - this.e;
            }
            return this.s - o.s;
        }
    }


}