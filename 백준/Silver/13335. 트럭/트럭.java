import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,w,L;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        int cnt=0;
        int Lcnt=0;
        for(int i=0; i<w; i++){
            bridge.add(0);
        }
        while(!bridge.isEmpty()){
            cnt++;
            Lcnt-=bridge.poll();
            if(!queue.isEmpty()){
                if(queue.peek()+Lcnt<=L){
                    Lcnt+=queue.peek();
                    bridge.add(queue.poll());
                }else{
                    bridge.add(0);
                }
            }
        }
        System.out.println(cnt);
    }
}
