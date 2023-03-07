import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num16236아기상어 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int sharkX = -1;
    static int sharkY = -1;
    static int sharkSize =2;
    static int minX;
    static int minY;
    static int minDist;
    static int eatingCount =0;
    static int count=0;

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        N= Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    sharkX = i;
                    sharkY = j;
                    map[i][j]=0;
                }
            }
        }

        while(true){
            dist = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs(sharkX,sharkY);

            if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE){
                eatingCount++;
                map[minX][minY] = 0;
                sharkX = minX;
                sharkY = minY;
                count +=dist[minX][minY];

                if(eatingCount == sharkSize){
                    sharkSize++;
                    eatingCount=0;
                }
            }
            else{
                break;
            }
        }
        System.out.println(count);
    }
    private static void bfs(int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x,y));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(isInArea(nx,ny) && isMove(nx,ny) && dist[nx][ny]==0){
                    dist[nx][ny] = dist[p.x][p.y]+1;
                    if(isEat(nx,ny)){
                        if(minDist > dist[nx][ny]){
                            minDist = dist[nx][ny];
                            minX = nx;
                            minY = ny;
                        }
                        else if(minDist == dist[nx][ny]){
                            if(minX == nx){
                                if(minY>ny){
                                    minX=nx;
                                    minY =ny;
                                }
                            }
                            else if(minX >nx){
                                minX =nx;
                                minY = ny;
                            }
                        }
                    }
                    q.add(new Point(nx,ny));
                }

            }
        }
    }
    private static boolean isInArea(int x, int y){
        return x<N && y<N && x>=0 && y>=0;
    }
    private static boolean isMove(int x, int y){
        return map[x][y] <= sharkSize;
    }
    private static boolean isEat(int x, int y){
        return map[x][y] !=0 && map[x][y] < sharkSize;
    }

}
