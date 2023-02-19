import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum=0;
        while(pq.size()>1){
            int temp1 = pq.poll();
            int temp2 = pq.poll();

            sum+= (temp1 +temp2);

            pq.add(temp1 + temp2);
        }
        System.out.println(sum);
    }
}
