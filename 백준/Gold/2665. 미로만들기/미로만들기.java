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

    private static int n;
    private static int[][] board;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static int[][] dist;
    public static void main(String[] args) throws IOException{
      n = stoi(br.readLine());
      board = new int[n][n];
      dist = new int[n][n];

      for(int i=0; i<n; i++){
        String temp = br.readLine();
        for(int j=0; j<n; j++){
          board[i][j] = temp.charAt(j) - '0';
          dist[i][j] = Integer.MAX_VALUE;
        }
      }

      bfs();
      System.out.println(dist[n-1][n-1]);
    }

    private static void bfs(){
      Queue<Point> q = new ArrayDeque<>();
      q.add(new Point(0,0));
      dist[0][0] = 0;
      while(!q.isEmpty()){
        Point current = q.poll();
        for(int i=0; i<4; i++){
          int nx = current.x + dx[i];
          int ny = current.y + dy[i];
          if(isArea(nx,ny)){
            if(dist[nx][ny] > dist[current.x][current.y]){
              if(board[nx][ny] == 1){
                dist[nx][ny] = dist[current.x][current.y];
              }
              else{
                dist[nx][ny] = dist[current.x][current.y] +1;
              }
              q.add(new Point(nx,ny));
            }
          }
        }
      }
    }

    private static boolean isArea(int x, int y){
      return 0<= x && x<n && 0<=y && y<n;
    }
}