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
      int[] arr = new int[N+1];
      int[] dp = new int[N+1];
      for(int i=1; i<=N; i++){
        arr[i] = stoi(br.readLine());
      }
      dp[1] = arr[1];
      if(N>1){
        dp[2] = arr[1] + arr[2];
      }
      for(int i=3; i<=N; i++){
        dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] +arr[i-1] + arr[i]));
      }
      System.out.println(dp[N]);
//==========================================================================================
    }

// 지워==================================================================================================


// 지워==================================================================================================

}