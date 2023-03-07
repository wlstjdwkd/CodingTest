import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int min;
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Pos implements Comparable<Pos>{
        int x, y;
        int time; // 복구하는 데 든 시간

        Pos(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o) {
            return this.time-o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        int T= Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N][N];

            arr = new int[N][N];
            for(int i=0; i<N; i++){
                String s = br.readLine();
                for(int j=0; j<N; j++){
                    arr[i][j]= s.charAt(j) -'0';
                }
            }

            bfs(0,0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs(int x, int y) {
        PriorityQueue<Pos> q = new PriorityQueue<>();

        q.add(new Pos(x, y, 0));
        visit[x][y] = true;

        while(!q.isEmpty()) {
            Pos p = q.poll();

            int curX = p.x;
            int curY = p.y;
            int curT = p.time;

            if(curX == N-1 && curY == N-1) {
                min = curT;
            }

            for(int t=0; t<4; t++) {
                int nx = curX + dx[t];
                int ny = curY + dy[t];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if(!visit[nx][ny]) {
                    int totalTime = curT + arr[nx][ny];
                    q.add(new Pos(nx, ny, totalTime));
                    visit[nx][ny] = true;
                }

            }

        }

    }
}