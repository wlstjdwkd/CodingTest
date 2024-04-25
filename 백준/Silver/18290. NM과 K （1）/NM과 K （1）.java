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
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M,K, answer = Integer.MIN_VALUE;

    public static void solve(int x, int y, int idx, int sum){
      if(idx == K){
        answer = Math.max(answer, sum);
        return;
      }

      for(int i=x; i<N; i++){
        for(int j=y; j<M; j++){
          if(!visited[i][j]){
            if(check(i,j)){
              visited[i][j] = true;
              solve(x, y, idx+1, sum+ arr[i][j]);
              visited[i][j] = false;
            }
          }
        }
      }
    }

    private static boolean check(int x, int y){
      boolean flag = true;
      for(int i=0; i<4; i++){
        int next_x = x+dx[i];
        int next_y = y+dy[i];

        if(0<= next_x && next_x < N && 0<= next_y && next_y < M){
          if(visited[next_x][next_y]){
            flag = false;
          }
        }
      }
      return flag;
    }

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = stoi(st.nextToken());
      M = stoi(st.nextToken());
      K = stoi(st.nextToken());
      arr = new int[N][M];
      visited = new boolean[N+1][M+1];

      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++){
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      solve(0,0,0,0);
      System.out.println(answer);
    }

}