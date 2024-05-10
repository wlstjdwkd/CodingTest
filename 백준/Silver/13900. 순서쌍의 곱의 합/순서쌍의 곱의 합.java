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
      st = new StringTokenizer(br.readLine());
      long[] num = new long[N+1];
      long[] cumSum = new long[N+1];

      num[0] = 0l;
      cumSum[0] = 0l;
      for(int i=1; i<=N; i++){
        num[i] = Long.parseLong(st.nextToken());
        cumSum[i] = num[i] + cumSum[i-1];
      }

      long sumVal = 0l;
      for(int i=2; i<=N; i++){
        sumVal += num[i] * cumSum[i-1];
      }
      System.out.println(sumVal);

//==========================================================================================
    }

// 지워==================================================================================================



// 지워==================================================================================================

}