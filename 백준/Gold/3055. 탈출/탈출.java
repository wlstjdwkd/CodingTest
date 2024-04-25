import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
      return Integer.parseInt(s);
    }
  private static int[] dx ={-1,1,0,0};
    private static int[] dy ={0,0,-1,1};
    private static Queue<int[]> q = new ArrayDeque<>();
    private static Queue<int[]> water = new ArrayDeque<>();
    private static int r,c;
    private static char[][] map;
    private static int[][] count;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      r = stoi(st.nextToken());
      c= stoi(st.nextToken());

      map = new char[r][c];
      count = new int[r][c];

      for(int i=0; i<r; i++){
        String s = br.readLine();
        for(int j=0; j<c; j++){
          map[i][j] = s.charAt(j);
          if(map[i][j] == 'S'){
            q.add(new int[] {i,j,0});
          }
          else if(map[i][j] == '*'){
            water.add(new int[] {i,j});
          }
        }
      }

      bfs();
      System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS":answer);
    }

    public static void bfs(){
      while(!q.isEmpty()){
        int len = water.size();
        for(int i=0; i<len; i++){
          int[] t = water.poll();
          int x = t[0];
          int y = t[1];
          for(int k=0; k<4; k++){
            int nx = x+dx[k];
            int ny = y + dy[k];
            if(0<= nx && nx < r && 0<= ny && ny < c && map[nx][ny]=='.'){
              map[nx][ny] = '*';
              water.add(new int[]{nx,ny});
            }
          }
        }

        len = q.size();
        for(int i=0; i<len; i++){
          int[] t = q.poll();
          int x = t[0];
          int y = t[1];
          int time = t[2];

          for(int k=0; k<4; k++){
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(0<=nx && nx < r && 0<= ny && ny< c){
              if(map[nx][ny] == 'D'){
                answer = Math.min(answer, time+1);
                return;
              }
              else if(map[nx][ny]=='.'){
                map[nx][ny] = 'S';
                q.add(new int[]{nx,ny, time+1});
              }
            }
          }
        }
      }
    }
}