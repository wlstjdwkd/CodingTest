import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] input;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        for(int i=0; i<N; i++){
            input[i] = i+1;
        }
        visit = new boolean[N];
        arr = new int[M];
        dfs(0,0);
        System.out.println(sb.toString());
    }
    private static void dfs(int depth, int start){
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1,i);
                visit[i] = false;
            }
        }
    }

}
