import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class num10828스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            String s= br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            String t = st.nextToken();
            if(t.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(t.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            }
            else if(t.equals("size")){
                System.out.println(stack.size());
            }
            else if(t.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else{
                if(stack.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
