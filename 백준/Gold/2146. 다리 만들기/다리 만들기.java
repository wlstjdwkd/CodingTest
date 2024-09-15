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

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

    private static boolean isArea(int x, int y){
        return 0<= x && x<N && 0<=y && y<N;
    }

    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        int number = 2;
        for(int i=0; i< N; i++){
            for(int j=0; j< N; j++){
                if(map[i][j] == 1){
                    dfs(i,j,number++);
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j< N; j++){
                if(map[i][j] > 1){
                    bfs(i,j,map[i][j]);
                }
            }
        }

        System.out.println(min);
    }

    private static void bfs(int y, int x, int number){
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][N];
        visited[y][x] = true;
        q.add(new int[]{y, x,0});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int nowY = temp[0];
            int nowX = temp[1];
            int count = temp[2];

            if(map[nowY][nowX] != 0 && map[nowY][nowX] != number){
                min = Math.min(min,count-1);
            }

            if(count > min){
                return;
            }


            for(int i=0; i<4; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                if(isArea(nextX, nextY)){
                    if(map[nextY][nextX] != number){
                        if(!visited[nextY][nextX]){
                            visited[nextY][nextX] = true;
                            q.add(new int[]{nextY, nextX, count+1});
                        }
                    }
                }
            }
        }
    }

    private static void dfs(int y, int x, int number){
        visited[y][x] = true;
        map[y][x] = number;

        for(int i=0; i<4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(isArea(nextX, nextY)){
                if(!visited[nextY][nextX]){
                    if(map[nextY][nextX] == 1){
                        dfs(nextY,nextX,number);
                    }
                }
            }
        }
    }

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int min = Integer.MAX_VALUE;
    private static final int[] dy = {-1,1,0,0};
    private static final int[] dx = {0,0,-1,1};



}