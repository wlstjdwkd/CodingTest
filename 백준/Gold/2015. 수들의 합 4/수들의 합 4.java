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
      int N = stoi(st.nextToken());
      int K = stoi(st.nextToken());

      Map<Integer, Integer> map = new HashMap<>();
      int[] sum = new int[N+1];
      st = new StringTokenizer(br.readLine());
      for(int i=1; i<=N; i++){
        sum[i] = sum[i-1] + stoi(st.nextToken());
      }

      map.put(0,1);

      long answer = 0;
      for(int j=1; j<=N; j++){
        answer += map.getOrDefault(sum[j] - K, 0);
        map.put(sum[j], map.getOrDefault(sum[j], 0) + 1);
      }

      System.out.println(answer);

//==========================================================================================
    }

// 지워==================================================================================================



// 지워==================================================================================================

}