import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num15652NM4 {
    static int N;
    static int M;
    static int[] num;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N+1];
        visited = new boolean[N+1];
        dfs(0,0);
    }
    public static void dfs(int count, int idx){
        if(count == M){
            for(int i=0; i< M; i++){
                System.out.print(num[i]+ " ");
            }
            System.out.println("");
            return;
        }
        for(int i=1; i<=N; i++){
            if(idx<=i){
                num[count]= i;
                dfs(count+1, num[count]);
            }
        }
    }
}
