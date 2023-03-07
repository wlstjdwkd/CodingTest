import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++){
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                stack.pop();
            }
            else{
                stack.push(a);
            }
        }
        int sum=0;
        for(int i : stack){
            sum+=i;
        }
        System.out.println(sum);

    }
}
