import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.*;
import java.util.List;

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
        return 0<= x && x<n && 0<=y && y<m;
    }


    public static void main(String[] args) throws IOException {
        board = new char[n][m];

        for(int i=0; i<n; i++){
            String field = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = field.charAt(j);
            }
        }

        int count = 0;
        while(true){
            boolean isFinished = true;
            visited = new boolean[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(board[i][j] != '.'){
                        list = new ArrayList<>();
                        bfs(board[i][j], i, j);

                        if(list.size() >= 4){
                            isFinished = false;
                            for (Point point : list) {
                                board[point.x][point.y] = '.';
                            }
                        }

                    }
                }
            }

            if(isFinished){
                break;
            }
            fallPuyos();
            count++;

        }
        System.out.println(count);
    }

    private static char[][] board;
    private static final int[] dx = {0,0,-1,1};
    private static final int[] dy = {1,-1,0,0};
    private static boolean[][] visited;
    private static List<Point> list;
    private static final int n = 12;
    private static final int m = 6;

    private static void bfs(char c, int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        list.add(new Point(x, y));
        q.add(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(isArea(nx,ny)){
                    if(!visited[nx][ny]){
                        if(board[nx][ny] == c){
                            visited[nx][ny] = true;
                            list.add(new Point(nx,ny));
                            q.add(new Point(nx,ny));
                        }
                    }
                }
            }
        }
    }

    private static void fallPuyos(){
        for(int i=0; i<m; i++){
            for(int j=n-1; j>0; j--){
                if(board[j][i] == '.'){
                    for(int k=j-1; k>=0; k--){
                        if(board[k][i] != '.'){
                            board[j][i] = board[k][i];
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

}