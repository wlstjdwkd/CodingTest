import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;

public class Main {

    static int N,M;
    static int xpos[] = {0,0,1,-1,1,-1,1,-1};
    static int ypos[] = {1,-1,0,0,1,-1,-1,1};
    static int map[][];
    static int dis[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dis = new int[N][M];
        Queue<Point> q = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    q.add(new Point(j,i));
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0; i<8; i++){
                int nx = x+xpos[i];
                int ny = y+ypos[i];
                if(ny>=0 && ny<N && nx>=0 && nx<M){
                    if(dis[ny][nx] !=0 || map[ny][nx]==1) continue;
                    dis[ny][nx] = dis[y][x]+1;
                    answer = Math.max(answer, dis[ny][nx]);
                    q.add(new Point(nx,ny));
                }
            }
        }
        System.out.println(answer);
    }
}