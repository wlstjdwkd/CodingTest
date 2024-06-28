import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int time = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            pq.add(new Pair(time, end));
        }
        Pair tmp = pq.poll();

        int start = tmp.end-tmp.start;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(start < p.end){
                start = start - p.start;
            }
            else{
                start = p.end-p.start;
            }
        }

        if(start<0){
            System.out.println(-1);
        }
        else{
            System.out.println(start);
        }
    }
    private static int N;

    private static class Pair implements Comparable<Pair> {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            return o.end-this.end;
        }
    }

}