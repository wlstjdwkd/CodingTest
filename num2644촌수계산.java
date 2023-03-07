import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class num2644촌수계산 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static int x,y;
    static int[][] map;
    static int[] d;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b]=1;
            map[b][a]=1;
        }
        d = new int[n+1];
        bfs(x,y);
        if(d[y]==0){
            System.out.println(-1);
        }
        else{
            System.out.println(d[y]);
        }

    }
    private static void bfs(int start, int end){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()){
            int v = q.poll();
            if(v==end){
                break;
            }
            for(int i=1; i<=n;i++){
                if(map[v][i]==1 && d[i]==0){
                    d[i] = d[v]+1;
                    q.add(i);
                }
            }
        }
    }
}
