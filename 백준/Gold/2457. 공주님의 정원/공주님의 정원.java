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
        n = stoi(br.readLine());
        Flower[] flowers = new Flower[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sM = stoi(st.nextToken());
            int sD = stoi(st.nextToken());
            int eM = stoi(st.nextToken());
            int eD = stoi(st.nextToken());

            int start = sM * 100 + sD;
            int end = eM * 100 + eD;

            flowers[i] = new Flower(start, end);
        }

        Arrays.sort(flowers);

        int endDay = 1201;
        int start = 301;
        int count = 0;
        int max = 0;
        int index = 0;

        while(start<endDay){
            boolean isFind = false;

            for(int i = index; i< n; i++){
                if(flowers[i].start > start){
                    break;
                }

                if(max < flowers[i].end){
                    isFind = true;
                    max = flowers[i].end;
                    index = i +1;
                }
            }

            if(isFind){
               start = max;
               count++;
            }

            else{
                break;
            }
        }

        if(max < endDay){
            System.out.println(0);
        }
        else{
            System.out.println(count);
        }
    }

    private static int n;

    private static class Flower implements Comparable<Flower>{
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if(this.start == o.start){
                return o.end - this.end;
            }
            return this.start - o.start;
        }
    }
}