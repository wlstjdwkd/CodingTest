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
        return 0<= x && x<R && 0<=y && y<C;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        int result = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] == 'L'){
                    visit = new boolean[R][C];
                    int val = bfs(i,j);
                    result = Math.max(result, val);
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(int x, int y){
        Queue<Po> q = new ArrayDeque<>();
        q.add(new Po(x,y,0));
        visit[x][y] = true;
        int val = 0;
        while(!q.isEmpty()){
            Po p = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = p.x + moveX[d];
                int ny = p.y + moveY[d];
                if(isArea(nx,ny)){
                    if(!visit[nx][ny]){
                        if(arr[nx][ny] == 'L'){
                            q.add(new Po(nx,ny,p.cnt+1));
                            visit[nx][ny] = true;
                            val = Math.max(val, p.cnt+1);
                        }
                    }
                }
            }
        }
        return val;
    }

    private static class Po{
        int x, y;
        int cnt;
        public Po(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static int R,C;
    private static final int[] moveY = {-1,0,1,0};
    private static final int[] moveX = {0,1,0,-1};
    private static char[][] arr;
    private static boolean[][] visit;

}