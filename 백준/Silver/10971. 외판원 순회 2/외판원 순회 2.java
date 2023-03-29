import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static long min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            visited = new boolean[N];
            visited[i]= true;
            dfs(i,i,0);
        }

        System.out.println(min);
    }

    private static void dfs(int start, int now, long cost){
        if(allVisited()){
            if(arr[now][start]!=0){
                min = Math.min(min,cost+arr[now][0]);
            }
        }
        for(int i=1; i<N; i++){
            if(!visited[i] && arr[now][i]!=0){
                visited[i]=true;
                dfs(start, i, cost + arr[now][i]);
                visited[i] = false;
            }
        }
    }
    private static boolean allVisited() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

}