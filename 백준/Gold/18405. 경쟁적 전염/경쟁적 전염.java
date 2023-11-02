import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N,K;
    private static int[][] arr;

    private static int S,X,Y;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        loop:
        for(int i=0; i<S; i++){
            for(int j=1; j<=K; j++){
                spread(j);
                
                if(arr[X][Y]!=0){
                    break loop;
                }
            }
        }
        System.out.println(arr[X][Y]);
    }
    private static void spread(int virus){
        Queue<Point> q = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(arr[i][j] == virus){
                    q.add(new Point(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if(arr[nx][ny] != 0) continue;
                arr[nx][ny] = virus;
            }
        }

    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}