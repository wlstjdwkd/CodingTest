import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isArea(int x, int y){
        return 0<= x && x<h && 0<=y && y<w;
    }

    public static void main(String[] args) throws IOException {
        int tc = stoi(br.readLine());
        int x = 0, y = 0;
        while(tc -- > 0){
            st = new StringTokenizer(br.readLine());
            w = stoi(st.nextToken());
            h = stoi(st.nextToken());

            map = new char[h][w];
            fire = new ArrayDeque<>();

            for(int i=0; i<h; i++){
                String line = br.readLine();
                for(int j= 0; j<w; j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '@'){
                        x = i;
                        y = j;
                    }
                    else if(map[i][j] == '*'){
                        fire.add(new Point(i, j));
                    }
                }
            }

            escape(x,y);
        }
        System.out.println(sb.toString());
    }

    private static void escape(int sx, int sy){
        Queue<Point> q = new ArrayDeque<>();
        visit = new boolean[h][w];
        visit[sx][sy] = true;
        q.add(new Point(-1,-1));
        q.add(new Point(sx, sy));
        int time = -1;

        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.x == -1 && now.y == -1){
                burn();
                if(!q.isEmpty()){
                    q.add(now);
                }
                time++;
                continue;
            }

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(!isArea(nx, ny)){
                    sb.append(time+1).append("\n");
                    return;
                }

                if(map[nx][ny] == '.' && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }

        sb.append("IMPOSSIBLE\n");
    }

    private static void burn(){
        int size = fire.size();
        for(int s =0; s<size; s++){
            Point now = fire.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(isArea(nx,ny)){
                    if(map[nx][ny] == '.' || map[nx][ny] == '@'){
                        fire.add(new Point(nx,ny));
                        map[nx][ny] = '*';
                    }
                }

            }
        }
    }


    private static int w,h;
    private static char map[][];
    private static Queue<Point> fire;
    private static final int[] dx = {-1,1,0,0};
    private static final int[] dy = {0,0,-1,1};

    private static boolean[][] visit;


}