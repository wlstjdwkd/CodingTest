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
        int T = stoi(br.readLine());

        for(int tc = 0; tc<T; tc++){
            map = new char[xx][yy];

            int pin = 0;
            for(int i=0; i<xx; i++){
                String str = br.readLine();
                for(int j=0; j<yy; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'o'){
                        pin++;
                    }
                }
            }

            remainPin = pin;

            for(int i=0; i<xx; i++){
                for(int j=0; j<yy; j++){
                    if(map[i][j] == 'o'){
                        dfs(i,j,pin,0);
                    }
                }
            }
            br.readLine();

            sb.append(remainPin).append(" ").append(move).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int remain, int moveCnt){
        if(remain<= remainPin){
            remainPin = remain;
            move = moveCnt;
        }

        for(int d=0; d<4; d++){
            int nx = x+ dx[d];
            int ny = y+ dy[d];

            if(isArea(nx,ny) && map[nx][ny] == 'o'){
                int nnx = nx+dx[d];
                int nny = ny+dy[d];
                if(isArea(nnx, nny) && map[nnx][nny] == '.'){
                    map[x][y] = map[nx][ny] = '.';
                    map[nnx][nny] = 'o';

                    for(int i=0; i<xx; i++){
                        for(int j=0; j<yy; j++){
                            if(map[i][j] == 'o'){
                                dfs(i,j,remain-1,moveCnt+1);
                            }
                        }
                    }

                    map[x][y] = map[nx][ny] = 'o';
                    map[nnx][nny] = '.';
                }
            }
        }
    }

    private static boolean isArea(int x, int y){
        return 0<=x && x<xx & 0<=y && y<yy;
    }

    private static char[][] map;
    private static final int xx =5;
    private static final int yy =9;
    private static int remainPin, move;

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};

}