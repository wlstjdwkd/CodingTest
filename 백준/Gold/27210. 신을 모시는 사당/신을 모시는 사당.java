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

      int n = stoi(br.readLine());
      st = new StringTokenizer(br.readLine());
      int[] arr = new int[n];

      for(int i=0; i<n; i++){
        arr[i] = stoi(st.nextToken());
      }

      int[] dp = new int[n];
      int[] dp2 = new int[n];
      int ans = -10;
      for(int i=0; i<n; i++){
        int cur = arr[i]  ==1 ? -1 : 1;
        int cur2 = cur * -1;
        if(i==0){
          dp[i] = cur;
          dp2[i] = cur2;
        }
        else{
          dp[i] = Math.max(dp[i-1] + cur, cur);
          dp2[i] = Math.max(dp2[i-1] + cur2, cur2);
        }
      }

      for(int i=0; i<n; i++){
        ans = Math.max(ans, Math.max(dp[i], dp2[i]));
      }

      System.out.println(ans);


//==========================================================================================
    }

// 지워==================================================================================================



// 지워==================================================================================================

}