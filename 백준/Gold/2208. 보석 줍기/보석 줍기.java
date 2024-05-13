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

      arr = new int[N+1];
      sum = new int[N+1];
      dp = new int[N+1];
      for(int i=1; i<N+1; i++){
        arr[i] = stoi(br.readLine());
        sum[i] = sum[i-1] + arr[i];
      }

      dp[M] = sum[M];
      int maxResult = dp[M];

      for(int i=M+1; i<N+1; i++){
        dp[i] = Math.max(dp[i-1] + arr[i], sum[i] - sum[i-M]);
        maxResult = Math.max(maxResult, dp[i]);
      }

      if(maxResult<0){
        maxResult = 0;
      }

      System.out.println(maxResult);


//==========================================================================================
    }

// 지워==================================================================================================

    static int N,M;
    static int[] arr, sum, dp;

// 지워==================================================================================================

}