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
      int N = stoi(br.readLine());
      int[] seq = new int[N];
      int[] dp = new int[N];

      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++){
        seq[i] = stoi(st.nextToken());
      }

      for(int i=0; i<N; i++){
        dp[i] = 1;
        for(int j=0; j<i; j++){
          if(seq[j] < seq[i] && dp[i] < dp[j]+1){
            dp[i] = dp[j] +1;
          }
        }
      }

      int max = -1;
      for(int i=0; i<N; i++){
        max = Math.max(max, dp[i]);
      }
      System.out.println(max);
//==========================================================================================
    }

// 지워==================================================================================================

// 지워==================================================================================================

}