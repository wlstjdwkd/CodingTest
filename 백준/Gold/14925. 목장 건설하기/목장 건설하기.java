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
      int m = stoi(st.nextToken());
      int n = stoi(st.nextToken());

      int[][] board = new int[m][n];
      int[][] dp = new int[m+1][n+1];

      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
          board[i][j] = stoi(st.nextToken());
        }
      }

      int answer = 0;
      for(int i=1; i<=m; i++){
        for(int j=1; j<=n; j++){
          if(board[i-1][j-1] == 0){
            dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
            answer = Math.max(answer, dp[i][j]);
          }
        }
      }

      System.out.println(answer);

//==========================================================================================
    }

// 지워==================================================================================================



// 지워==================================================================================================

}