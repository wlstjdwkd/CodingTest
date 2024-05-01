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
      arr = new int[N];
      dfs(N,0,0);
      System.out.println(set.size());

//==========================================================================================
    }

// 지워==================================================================================================
    static int[] list = {1,5,10,50};
    static Set<Integer> set = new HashSet<>();
    static int[] arr;
    static int ans;


    static void dfs(int N, int depth, int index){
      if(depth==N){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
          sum += arr[i];
        }
        set.add(sum);
        return;
      }

      for(int i=index; i<list.length; i++){
        arr[depth] = list[i];
        dfs(N, depth+1, i);
      }
    }

// 지워==================================================================================================

}