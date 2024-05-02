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
      s = br.readLine();
      len = s.length();
      visit = new boolean[51];
      dfs(0,0,"");
//==========================================================================================
    }

// 지워==================================================================================================
    static String s;
    static boolean visit[];
    static int len;

    static void dfs(int idx, int N, String ans){
      if(idx == len){
        for(int i=1; i<=N; i++){
          if(!visit[i]){
            return;
          }
        }
        System.out.println(ans.trim());
        System.exit(0);
        return;
      }

      String tmp = s.substring(idx, idx+1);
      int num = stoi(tmp);
      if(!visit[num]){
        visit[num] = true;
        dfs(idx+1, (num>N) ? num : N, ans+ " "+tmp);
        visit[num] = false;

      }

      if(idx<len-1){
        String tmp2 = s.substring(idx, idx+2);
        num = stoi(tmp2);
        if(num<51 && !visit[num]){
          visit[num] = true;
          dfs(idx+2, (num>N) ? num : N, ans+" "+tmp2);
          visit[num] = false;
        }
      }
    }
// 지워==================================================================================================

}