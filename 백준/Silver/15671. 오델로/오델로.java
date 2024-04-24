import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static char[][] map;
    private static final int SIZE = 6;
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final char BLACK = 'B', WHITE = 'W';

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      map = new char[N+1][N+1];
      char horse = BLACK;
      for(int i=1; i<=SIZE; i++){
        Arrays.fill(map[i], '.');
      }

      map[3][3] = map[4][4] = WHITE;
      map[3][4] = map[4][3] = BLACK;

      for(int i=0; i<N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        set(horse, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        horse = horse == BLACK ? WHITE:BLACK;
      }
      int blackCnt = 0, whiteCnt = 0;

      for(int i=1; i<=SIZE; i++){
        for(int j=1; j<=SIZE;j++){
          if(map[i][j] == BLACK){
            blackCnt++;
          }
          else if(map[i][j] == WHITE){
            whiteCnt++;
          }

          System.out.print(map[i][j]);
        }
        System.out.println();
      }

      System.out.println(blackCnt>whiteCnt ? "Black" : "White");
    }

    private static void set(char horse, int x, int y){
      map[x][y] = horse;
      for(int d = 0; d<8; d++){
        int i = x, j = y;
        Stack<int[]> stack = new Stack<>();
        boolean stuck = false;

        while(true){
          int ni = i+di[d];
          int nj = j+dj[d];
          if(!isRange(ni,nj) || map[ni][nj] == '.'){
            break;
          }
          else if(map[ni][nj] == horse){
            stuck = true;
            break;
          }

          stack.push(new int[]{ni,nj});
          i=ni;
          j=nj;
        }
        if(stuck){
          while(!stack.isEmpty()){
            int[] now = stack.pop();
            map[now[0]][now[1]] = horse;
          }
        }
      }


    }

    private static boolean isRange(int x, int y){
      return 1<=x && x<=SIZE && 1<=y&& y<=SIZE;
    }
}