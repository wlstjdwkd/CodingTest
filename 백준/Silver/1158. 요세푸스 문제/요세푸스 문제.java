import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            q.add(i);
        }
        int cnt=1;
        int icnt=0;
        while(!q.isEmpty()){
            if(cnt==K){
                arr[icnt++]=q.poll();
                cnt=1;
            }
            else{
                q.add(q.poll());
                cnt++;
            }
        }
        for(int i=0; i<N; i++){
            if(i==0){
                sb.append("<");
            }
            if(i==N-1){
                sb.append(arr[i]).append(">");
                break;
            }

            sb.append(arr[i]).append(", ");


        }
        System.out.println(sb);
    }
}
