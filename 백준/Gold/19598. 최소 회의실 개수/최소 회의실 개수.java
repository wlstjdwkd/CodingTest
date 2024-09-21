import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Time[] times = new Time[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            times[i] = new Time(start, end);
        }

        Arrays.sort(times);

        pq.add(times[0].end);

        for(int i=1; i<N; i++){
            if(pq.peek() <= times[i].start){
                pq.poll();
            }

            pq.add(times[i].end);
        }

        System.out.println(pq.size());
    }

    private static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.start == o.start){
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }



}