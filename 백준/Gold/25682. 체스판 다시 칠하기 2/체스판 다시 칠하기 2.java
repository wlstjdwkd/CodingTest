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
      int N,M,K, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      int[][] board;
      st = new StringTokenizer(br.readLine());
      N = stoi(st.nextToken());
      M = stoi(st.nextToken());
      K = stoi(st.nextToken());
      board = new int[N+1][M+1];

      boolean color = false;

      for(int i=1; i<=N; i++){
          String str = br.readLine();
          for(int j=1; j<=M; j++){
              char c = str.charAt(j-1);
              if(!color && c == 'W'){
                  board[i][j] = 1;
              }
              else if(color && c == 'B'){
                  board[i][j] = 1;
              }

              color = !color;
          }
          if(M % 2 ==0){
              color = !color;
          }
      }

      for(int i=1; i<=N; i++){
          int temp= board[i][1];
          for(int j=2; j<=M; j++){
              temp += board[i][j];
              board[i][j]= temp;
          }
      }

      for(int i=1; i<=M; i++){
          int temp = board[1][i];
          for(int j=2; j<=N; j++){
              temp += board[j][i];
              board[j][i] = temp;
          }
      }

      for(int i=K; i<=N; i++){
          for(int j=K; j<=M; j++){
              int temp = board[i][j] - (board[i-K][j] + board[i][j-K] - board[i-K][j-K]);
              min = Math.min(min, temp);
              max = Math.max(max, temp);
          }
      }

      int answer = Math.min(min, K*K -max);
        System.out.println(answer);


//==========================================================================================
    }

// 지워==================================================================================================



// 지워==================================================================================================

}