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
      n = stoi(st.nextToken());
      k = stoi(st.nextToken());
      st = new StringTokenizer(br.readLine());
      arr = new int[n];
      for(int i=0; i<n; i++){
        arr[i] = stoi(st.nextToken());
      }

      visit = new boolean[n];
      ans = 0;
      back(500,0);
      System.out.println(ans);
//==========================================================================================
    }

// 지워==================================================================================================
    static int n,k;
    static int[] arr;
    static boolean[] visit;
    static int ans;

    static void back(int sum, int idx){
      if(idx == n){
        ans++;
        return;
      }

      for(int i=0; i<n; i++){
        if(!visit[i] && (sum + arr[i] -k) >= 500){
          visit[i] = true;
          back(sum+arr[i] -k, idx+1);
          visit[i] = false;
        }
      }
    }
// 지워==================================================================================================

}