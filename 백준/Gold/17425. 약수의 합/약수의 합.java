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
      long[] fx = new long[MAX];
      long[] gx = new long[MAX];

      Arrays.fill(fx, 1);

      for(int i =2; i<MAX; i++){
        for(int j=1; i*j <MAX; j++){
          fx[i*j] +=i;
        }
      }

      for(int i=1; i<MAX; i++){
        gx[i] = gx[i-1] + fx[i];
      }

      int T = stoi(br.readLine());

      for(int i=0; i<T; i++){
        sb.append(gx[stoi(br.readLine())]).append("\n");
      }
      System.out.println(sb);
//==========================================================================================
    }

// 지워==================================================================================================
    static final int MAX = 1000001;
// 지워==================================================================================================

}