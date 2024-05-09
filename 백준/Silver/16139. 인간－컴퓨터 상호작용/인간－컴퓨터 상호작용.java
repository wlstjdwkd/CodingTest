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
      String s = br.readLine();
      int q = stoi(br.readLine());
      int l = s.length();

      int[][] memos = new int[l+1][26];
      memos[1][s.charAt(0)-'a']++;
      for(int i=2; i<=l; i++){
        int idx = s.charAt(i-1) - 'a';
        for(int j=0; j<26; j++){
          int before = memos[i-1][j];
          memos[i][j] = j==idx? before+1 : before;
        }
      }

      for(int i=0; i<q; i++){
        st = new StringTokenizer(br.readLine());
        int idx = st.nextToken().charAt(0) - 'a';
        int start = stoi(st.nextToken())+1;
        int end = stoi(st.nextToken())+1;

        sb.append(memos[end][idx] - memos[start-1][idx]).append("\n");
      }
      System.out.println(sb);
//==========================================================================================
    }

// 지워==================================================================================================


// 지워==================================================================================================

}