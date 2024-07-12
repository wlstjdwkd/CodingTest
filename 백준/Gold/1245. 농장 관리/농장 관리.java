import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

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
        return 0<= x && x<N && 0<=y && y<M;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = stoi(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    bfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int x, int y, int height) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y));
        boolean topFlag = true;
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            int nx = p.x, ny = p.y;
            for (int d = 0; d < 8; d++) {
                int dx = nx + dt[d][0];
                int dy = ny + dt[d][1];
                if(isArea(dx, dy)){
                    if(map[dx][dy] > height){
                        topFlag = false;
                    }
                    else if(!visited[dx][dy] && map[dx][dy] == height){
                        visited[dx][dy] = true;
                        q.add(new Point(dx, dy));
                    }
                }
            }
        }
        if(topFlag){
            ans++;
        }
    }

    private static int N,M,ans = 0, minHeight = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

}