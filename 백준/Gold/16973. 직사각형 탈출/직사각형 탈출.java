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

    public static void main(String[] args) throws IOException {
//===========================================================================================
      st = new StringTokenizer(br.readLine());
      N = stoi(st.nextToken());
      M = stoi(st.nextToken());

      list = new ArrayList<>();
      map = new int[N+1][M+1];
      for(int i=1; i<=N; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=1; j<=M; j++){
          map[i][j] = stoi(st.nextToken());
          if(map[i][j] == 1){
            map[i][j] = -1;
            list.add(new Pos(i,j));
          }
        }
      }

      st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken()); // 사각형 가로 길이
      w = Integer.parseInt(st.nextToken()); // 사각형 세로 길이
      sx = Integer.parseInt(st.nextToken()); // 시작 위치
      sy= Integer.parseInt(st.nextToken()); // 시작 위치
      fx = Integer.parseInt(st.nextToken()); // 목표 위치
      fy = Integer.parseInt(st.nextToken()); // 목표 위치

      ans = -1; // 답 ( 최소 거리 )
      bfs();
      System.out.println(ans);
//==========================================================================================
    }

// 지워==================================================================================================
    static int N, M;
    static int h, w, sx, sy, fx, fy;
    static int[][] map;
    static List<Pos> list;
    static int ans;
    static class Pos{
      int x,y;

      public Pos(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }

    static void bfs(){
      Queue<Pos> q = new ArrayDeque<>();
      boolean[][] isChecked = new boolean[N+1][M+1];
      q.add(new Pos(sx,sy));
      isChecked[sx][sy] = true;

      while(!q.isEmpty()){
        Pos p = q.poll();

        int curX = p.x;
        int curY = p.y;

        if(curX == fx && curY == fy){
          ans = map[curX][curY];
          return;
        }
        for(int t=0; t<4; t++){
          int nx = curX +dx[t];
          int ny = curY + dy[t];
          if(isArea(nx,ny)){
            if(isChecked[nx][ny]){
              continue;
            }

            if(!isPossible(nx,ny)){
              continue;
            }

            if(map[nx][ny] == 0){
              q.add(new Pos(nx,ny));
              isChecked[nx][ny] = true;
              map[nx][ny] = map[curX][curY] +1;
            }
          }
        }
      }
    }

    private static boolean isPossible(int x, int y){
      if(x+h-1>N || y+w-1 >M){
        return false;
      }
      for(int i=0; i<list.size(); i++){
        Pos p = list.get(i);
        int px = p.x;
        int py = p.y;

        if(px>=x && px<=x+h-1 && py>=y && py <=y+w-1){
          return false;
        }
      }

      return true;
    }

    private static boolean isArea(int x,int y){
      return 1<=x && x<=N && 1<= y && y<=M;
    }


// 지워==================================================================================================

}