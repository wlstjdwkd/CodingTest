import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num15649NM1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];
        dfs(N,M,0);

    }
    public static void dfs(int N, int M, int depth){
        if(depth==M){
            for(int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i]= true;
                arr[depth] = i+1;
                dfs(N, M, depth+1);
                visit[i] = false;
            }

        }
    }
}
