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

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<n && 0<=y && y<m;
//    }


    public static void main(String[] args) throws IOException {
        while(true){
            st = new StringTokenizer(br.readLine());
            l = stoi(st.nextToken());
            r = stoi(st.nextToken());
            c = stoi(st.nextToken());
            if(l==0 && r==0 && c==0){
                System.out.println(sb.toString());
                return;
            }

            int sx = 0;
            int sy = 0;
            int sz = 0;
            map = new char[l][r][c];

            for(int i=0; i<l; i++){
                for(int j=0; j<r; j++){
                    String line = br.readLine();
                    for(int k=0; k<c; k++){
                        map[i][j][k] = line.charAt(k);
                        if(map[i][j][k] == 'S'){
                            sx = k;
                            sy = j;
                            sz = i;
                            map[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();
            }
            bfs(sx,sy,sz);
        }
    }

    private static int l, r, c;
    private static char[][][] map;
    private static final int[] dx = {-1,1,0,0,0,0};
    private static final int[] dy = {0,0,-1,1,0,0};
    private static final int[] dz = {0,0,0,0,-1,1};

    private static void bfs(int x, int y, int z){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] check = new boolean[l][r][c];
        q.add(new int[]{x,y,z,0});
        check[z][y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int px = cur[0];
            int py = cur[1];
            int pz = cur[2];
            int move = cur[3];

            if(map[pz][py][px] == 'E'){
                sb.append("Escaped in ").append(move).append(" minute(s).\n");
                return;
            }

            for(int d=0; d<6; d++){
                int nx = px + dx[d];
                int ny = py + dy[d];
                int nz = pz + dz[d];
                if(0<= nx && nx <c && 0<= ny && ny <r && 0<= nz && nz < l){
                    if(!check[nz][ny][nx]){
                        if(map[nz][ny][nx] != '#'){
                            check[nz][ny][nx] = true;
                            q.add(new int[]{nx,ny,nz,move+1});
                        }
                    }
                }
            }
        }

        sb.append("Trapped!\n");
    }

}