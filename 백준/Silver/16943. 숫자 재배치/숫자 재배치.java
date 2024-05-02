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
      A = st.nextToken();
      B = st.nextToken();
      C = "";

      a = stoi(A);
      b = stoi(B);
      c = -1;

      isVisited = new boolean[A.length()];

      DFS();
      System.out.println(c);
//==========================================================================================
    }

// 지워==================================================================================================
    static String A,B,C;
    static int a,b,c;
    static boolean[] isVisited;

    static void DFS(){
      if(C.length() == A.length()){
        if(stoi(C) < b){
          c = Math.max(c, stoi(C));
        }
        return;
      }

      for(int i=0; i< A.length(); i++){
        if((C.length() == 0 && A.charAt(i) == '0') || isVisited[i]){
          continue;
        }

        isVisited[i] = true;
        C += A.charAt(i);
        DFS();
        isVisited[i] = false;
        C= C.substring(0, C.length()-1);
      }
    }
// 지워==================================================================================================

}