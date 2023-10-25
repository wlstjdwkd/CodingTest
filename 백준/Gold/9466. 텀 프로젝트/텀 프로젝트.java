import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] arr;
    private static int count=0;
    private static boolean[] visited;
    private static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());
        while(T-->0){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;
            arr=new int[n+1];

            for(int i=1; i<n+1; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<n+1; i++){
                dfs(i);
            }

            System.out.println(n-count);
        }

    }

    private static void dfs(int now){
        if(visited[now]){
            return;
        }

        visited[now] = true;
        int next = arr[now];

        if(visited[next] != true){
            dfs(next);
        }
        else{
            if(finished[next] != true){
                count++;
                for(int i=next; i != now; i = arr[i]){
                    count++;
                }
            }
        }

        finished[now] = true;
    }
}