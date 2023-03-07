import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int i=1;
        for(int j=1; j<=a; j++){
            queue.add(j);
        }
        while(queue.size()>1){
            if(i%2==0){
                queue.add(queue.poll());
            }
            else{
                queue.poll();
            }
            i++;
        }

        System.out.println(queue.poll());
    }
}
