import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M,N;
    static int[][] graph;
    static int[] dx={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Point> q = new ArrayDeque<>();
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph=new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==1){
                    q.add(new Point(i,j));
                }
            }
        }

        System.out.println(bfs());

    }
    private static int bfs(){
        while(!q.isEmpty()){
            Point p = q.poll();

            int xx = p.x;
            int yy = p.y;
            for(int i=0; i<4; i++){
                int nx = xx+ dx[i];
                int ny = yy+ dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(graph[nx][ny]==0){
                        q.add(new Point(nx,ny));

                        graph[nx][ny] = graph[xx][yy]+1;
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==0){
                    return -1;
                }
                result = Math.max(result,graph[i][j]);
            }
        }
        return result -1;
    }
}