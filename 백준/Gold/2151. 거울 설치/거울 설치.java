import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
      return Integer.parseInt(s);
    }
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    static int[] dx = {-1, 0, 1, 0}; // 상좌 (북남)
    static int[] dy = {0, -1, 0, 1}; // 하우 (서동)

    public static void main(String[] args) throws IOException{
//===========================================================================================

      N = Integer.parseInt(br.readLine());
      map = new char[N][N];
      int idx = 0;
      for(int i=0; i<N; i++){
        String line = br.readLine();
        for(int j=0; j<N; j++){
          map[i][j] = line.charAt(j);

          if(map[i][j] == '#'){
            if(idx ==0){
              sx = i;
              sy = j;
            }
            else{
              ex = i;
              ey = j;
            }
            idx++;
          }
        }
      }
      bfs();
    }

    public static void bfs(){
      PriorityQueue<Mirror> pq = new PriorityQueue<>();
      boolean[][][] visited = new boolean[N][N][4];
      for(int i=0; i<4; i++){
        pq.add(new Mirror(sx, sy, i, 0));
      }

      while(!pq.isEmpty()){
        Mirror cur = pq.poll();

        int x = cur.x;
        int y = cur.y;
        int dir = cur.dir;
        int cnt = cur.cnt;

        visited[x][y][dir] = true;

        if(x == ex && y == ey){
          System.out.println(cnt);
          return;
        }

        int nx = x+dx[dir];
        int ny = y +dy[dir];
        if(isArea(nx,ny)){
          if(!visited[nx][ny][dir] && map[nx][ny] != '*'){
            if(map[nx][ny] == '!'){
              int nDir = (dir+3) %4;
              pq.add(new Mirror(nx,ny, nDir, cnt+1));

              nDir = (dir+1) %4;
              pq.add(new Mirror(nx,ny,nDir,cnt+1));
            }
            pq.add(new Mirror(nx,ny,dir,cnt));
          }
        }

      }
    }

    private static boolean isArea(int x,int y){
      return 0<=x && x< N && 0<= y && y<N;
    }

    private static int N;
    private static int sx, sy, ex, ey;
    private static char[][] map;

    private static class Mirror implements Comparable<Mirror>{
      int x,y,dir,cnt;
      Mirror(int x, int y, int dir, int cnt){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
      }

      @Override
      public int compareTo(Mirror o){
        return this.cnt- o.cnt;
      }

//===========================================================================================

    }
}