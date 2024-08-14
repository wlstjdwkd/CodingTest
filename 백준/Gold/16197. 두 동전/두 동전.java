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

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<n && 0<=y && y<n;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        board = new char[n][m];
        coin = new Coin[2];
        int coinIdx = 0;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                char c = str.charAt(j);
                if(c=='o'){
                    coin[coinIdx++] = new Coin(i,j);
                }
                board[i][j] = c;
            }
        }

        visited = new boolean[n][m][n][m];
        System.out.println(bfs());

    }
    private static int bfs(){
        Queue<TwoCoins> q = new ArrayDeque<>();
        q.add(new TwoCoins(coin[0].x, coin[0].y, coin[1].x, coin[1].y,0));
        visited[coin[0].x][coin[0].y][coin[1].x][coin[1].y] = true;

        while(!q.isEmpty()){
            TwoCoins current = q.poll();
            if(current.count >= 10){
                break;
            }
            for(int i=0; i<4; i++){
                int nx1 = current.x1 + dx[i];
                int nx2 = current.x2 + dx[i];
                int ny1 = current.y1 + dy[i];
                int ny2 = current.y2 + dy[i];

                if(!canMoveCoin(nx1, ny1)){
                    nx1 = current.x1;
                    ny1 = current.y1;
                }
                if(!canMoveCoin(nx2, ny2)){
                    nx2 = current.x2;
                    ny2 = current.y2;
                }

                int flag = 0;
                if(0<=nx1 && 0<=ny1 && nx1<n && ny1<m){
                    flag++;
                }
                if(0<=nx2 && 0<=ny2 && nx2<n && ny2<m){
                    flag++;
                }

                if(flag == 1){
                    return current.count+1;
                }
                else if(flag == 2 && !visited[nx1][ny1][nx2][ny2]){
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.add(new TwoCoins(nx1, ny1, nx2, ny2, current.count + 1));
                }
            }
        }
        return -1;
    }

    public static boolean canMoveCoin(int nx, int ny) {
        if(nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == '#') {
            return false;
        }
        return true;
    }

    private static int n,m;
    private static final int[] dx = {0,1,0,-1};
    private static final int[] dy = {1,0,-1,0};
    private static char[][] board;
    private static Coin[] coin;
    private static boolean[][][][] visited;

    private static class Coin{
        int x,y;
        public Coin(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static class TwoCoins{
        int x1,y1,x2,y2, count;
        public TwoCoins(int x1, int y1, int x2, int y2, int count){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }




}