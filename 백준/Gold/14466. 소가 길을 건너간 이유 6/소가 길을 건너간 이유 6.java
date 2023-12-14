import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, K, R;
    static boolean[][] visited;
    static Point[] cows;
    static ArrayList<Point>[][] bridges;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        cows = new Point[K];
        bridges = new ArrayList[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bridges[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) -1;
            int c1 = Integer.parseInt(st.nextToken()) -1;
            int r2 = Integer.parseInt(st.nextToken()) -1;
            int c2 = Integer.parseInt(st.nextToken()) -1;

            bridges[r1][c1].add(new Point(r2,c2));
            bridges[r2][c2].add(new Point(r1,c1));
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;

            cows[i] = new Point(r,c);
        }

        System.out.println(go());

    }

    private static int go(){
        int cnt = 0;

        for(int i=0; i<K; i++){
            visited = new boolean[N][N];
            move(cows[i].x, cows[i].y);

            for(int j=i+1; j<K; j++){
                if(!visited[cows[j].x][cows[j].y]){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void move(int x, int y){
        visited[x][y] = true;
        for(int d=0; d<4; d++){
            int xx = x+ dx[d];
            int yy = y+ dy[d];

            if(xx<0 || xx>=N || yy<0 || yy>=N || visited[xx][yy]){
                continue;
            }

            if(visited[xx][yy]){
                continue;
            }

            if(bridges[x][y].contains(new Point(xx,yy))){
                continue;
            }

            move(xx,yy);
        }
    }
}