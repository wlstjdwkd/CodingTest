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
    static int[][] visit;
    static int min;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Point{
        int x,y,dis,drill;

        public Point(int x, int y, int dis, int drill) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visit = new int[N][M];
        min = Integer.MAX_VALUE;
        for(int i=0; i<N;i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = s.charAt(j)-'0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0,0);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }
    }

    private static void bfs(int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x,y,1,0));
        visit[x][y]=0;
        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x==N-1 && p.y ==M-1){
                min=p.dis;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(isInArea(nx,ny) && visit[nx][ny] >p.drill){
                    if(graph[nx][ny]==0){
                        //빈공간
                        visit[nx][ny] = p.drill;
                        q.add(new Point(nx,ny, p.dis+1,p.drill));
                    }
                    else{
                        //벽
                        if(p.drill==0){
                            //뚫기 가능
                            visit[nx][ny]=p.drill +1;
                            q.add(new Point(nx,ny,p.dis+1,p.drill+1));
                        }
                    }
                }
            }
        }

    }

    private static boolean isInArea(int x,int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
}