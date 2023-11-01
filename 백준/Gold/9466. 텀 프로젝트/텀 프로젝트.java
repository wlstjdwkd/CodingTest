import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];

            result = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=n; i++){
                if(!finished[i]){
                    dfs(i);
                }
            }
            sb.append(n-result).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int cur){
        if(finished[cur]) return;
        if(visited[cur]){
            finished[cur] = true;
            result++;
        }
        visited[cur] = true;
        dfs(arr[cur]);
        finished[cur] = true;
//        visited[cur] = false;


    }
}