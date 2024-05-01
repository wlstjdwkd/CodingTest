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
      n = Integer.parseInt(br.readLine());
      arr = br.readLine();
      map = new char[n][n];

      int idx = 0;
      for(int i=0; i<n; i++){
        for(int j=i; j<n; j++){
          map[i][j] = arr.charAt(idx++);
        }
      }

      result = new int[n];
      dfs(0);

    }
    static void dfs(int idx){
      if(idx == n){
        String str = "";
        for(int i=0; i<result.length; i++){
          str+= result[i]+" ";
        }
        System.out.println(str);

        System.exit(0);
      }

      for(int i = -10; i<11; i++){
        result[idx] = i;
        if(check(idx+1)){
          dfs(idx+1);
        }
      }
    }

    static boolean check(int length){
      for(int i=0; i<length; i++){
        int sum = 0;
        for(int j=i; j<length; j++){
          sum+=result[j];
          if(map[i][j] != (sum==0? '0' : (sum>0) ? '+' : '-')){
            return false;
          }
        }
      }

      return true;
    }

    static int n;
    static String arr;
    static int[] result;
    static char[][] map;

//===========================================================================================

}