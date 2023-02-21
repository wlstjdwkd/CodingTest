import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] input;
    static boolean[] visit;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[N];
        visit = new boolean[N];
        dfs(0);
        System.out.println(result);
    }
    private static void dfs(int count){
        if(count==N){
            result = Math.max(getSum(),result);
            return;
        }
        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[count] = input[i];
                dfs(count+1);
                visit[i] = false;
            }
        }
    }
    private static int getSum(){
        int sum =0;
        for(int i=0; i<N-1; i++){
            sum += Math.abs(arr[i]- arr[i+1]);
        }
        return sum;
    }
}
