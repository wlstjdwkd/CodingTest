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
      parent = new int[n];
      int root = 0;
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        parent[i] = stoi(st.nextToken());
        if(parent[i] == -1){
          root =i;
        }
      }
      delete = stoi(br.readLine());

      deleteNode(delete);
      count = 0;
      visited = new boolean[n];
      countLeaf(root);

      System.out.println(count);

//==========================================================================================
    }

// 지워==================================================================================================

    static int n,delete;
    static int[] parent;
    static int count;
    static boolean[] visited;

    private static void deleteNode(int d){
      parent[d] = -2;
      for(int i=0; i<n; i++){
        if(parent[i] == d){
          deleteNode(i);
        }
      }
    }

    private static void countLeaf(int s){
      boolean isLeaf = true;
      visited[s] = true;
      if(parent[s] != -2){
        for(int i=0; i<n; i++){
          if(parent[i] == s && visited[i] ==false){
            countLeaf(i);
            isLeaf = false;
          }
        }
        if(isLeaf){
          count++;
        }
      }


    }

// 지워==================================================================================================

}