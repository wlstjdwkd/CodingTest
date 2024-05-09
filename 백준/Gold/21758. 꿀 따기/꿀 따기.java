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
      n = stoi(br.readLine());
      st = new StringTokenizer(br.readLine());
      honeys = new int[n];
      toRightTotal = new long[n];
      toLeftTotal = new long[n];
      long temp = 0;
      for(int i=0; i<n; i++){
        honeys[i] = stoi(st.nextToken());

        temp+=honeys[i];
        toRightTotal[i] = temp;
      }

      temp = 0;
      for(int i=n-1; i>=0; i--){
        temp += honeys[i];
        toLeftTotal[i] = temp;
      }

      total = toRightTotal[n-1];
      
      case1();
      case2();
      case3();

      System.out.println(maxCount);

//==========================================================================================
    }

// 지워==================================================================================================

  static int n;
    static int[] honeys;
    static long maxCount;
    static long total;
    static long[] toRightTotal;
    static long[] toLeftTotal;

    static void case1(){
      long bee1, bee2;
      for(int i=1; i<=n-2; i++){
        bee1 = total - honeys[0] - honeys[i];
        bee2 = total - toRightTotal[i];
        maxCount = Math.max(maxCount, bee1+bee2);
      }
    }

    static void case2(){
      long bee1, bee2;

      for(int i = n-2; i>=1; i--){
        bee1 = total - honeys[n-1] - honeys[i];
        bee2 = total - toLeftTotal[i];
        maxCount = Math.max(maxCount, bee1+bee2);
      }
    }

    static void case3(){
      long bee1, bee2;

      for(int i=1; i<=n-2; i++){
        bee1 = toRightTotal[i] - honeys[0];
        bee2 = toLeftTotal[i] - honeys[n-1];
        maxCount = Math.max(maxCount, bee1+bee2);
      }
    }

// 지워==================================================================================================

}