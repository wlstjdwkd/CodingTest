import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Jewerly implements Comparable<Jewerly>{
        int mass;
        int value;
        Jewerly(int mass, int value){
            this.mass=mass;
            this.value=value;
        }

        @Override
        public int compareTo(Jewerly o) {
            if(this.mass == o.mass){
                return o.value-this.value;
            }
            return this.mass-o.mass;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewerly[] jewerlies = new Jewerly[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int mass = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewerlies[i] = new Jewerly(mass, value);
        }

        Arrays.sort(jewerlies);

        int[] bags = new int[K];

        for(int i=0; i<K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long ans = 0;
        for(int i=0,j=0; i<K; i++){
            while(j<N && jewerlies[j].mass<=bags[i]){
                pq.add(jewerlies[j++].value);
            }

            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }
}