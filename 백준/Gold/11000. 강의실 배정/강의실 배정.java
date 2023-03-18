import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S[], T[];
    static class Lecture implements Comparable<Lecture>{
        int start,end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture l){
            if(this.start==l.start){
                return this.end-l.end;
            }
            return this.start-l.start;
        }
    }
    public static void main(String[] args) throws IOException {
        N= Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(s,e);

        }
        Arrays.sort(lectures);

        pq.add(lectures[0].end);

        for(int i=1; i<N; i++){
            if(lectures[i].start>=pq.peek()){
                pq.poll();
            }
            pq.add(lectures[i].end);
        }

        System.out.println(pq.size());
    }
}