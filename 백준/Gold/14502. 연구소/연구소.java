import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int maxResult;
    static class Virus{
        int x,y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());


            }
        }

        dfs(0);
        System.out.println(maxResult);
    }
    private static void dfs(int cnt){
        if(cnt==3){
            bfs();
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==0){
                    graph[i][j]=1;
                    dfs(cnt+1);
                    graph[i][j]=0;
                }
            }
        }
    }
    private static void bfs(){
        Queue<Virus> q = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==2){
                    q.add(new Virus(i,j));

                }
            }
        }

        int copyMap[][] = new int[N][M];
        for(int i=0; i<N; i++){
            copyMap[i] = graph[i].clone();
        }

        while(!q.isEmpty()){
            Virus v = q.poll();
            int xx = v.x;
            int yy = v.y;
            for(int i=0; i<4; i++){
                int nx = xx + dx[i];
                int ny = yy + dy[i];
                if(nx>=0 && ny >=0 && nx<N && ny<M){
                    if(copyMap[nx][ny]==0){
                        q.add(new Virus(nx,ny));
                        copyMap[nx][ny]=2;
                    }
                }
            }
        }

        check(copyMap);

    }
    private static void check(int[][] arr){
        int result=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==0){
                    result++;
                }
            }
        }
        maxResult=Math.max(maxResult,result);
    }

}