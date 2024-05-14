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
      N = stoi(st.nextToken());
      K = stoi(st.nextToken());

      bfs();

      Stack<Integer> stack = new Stack<>();
      stack.push(K);
      int index = K;
      while(index != N){
        stack.push(parent[index]);
        index = parent[index];
      }

      sb.append(time[K] -1 + "\n");
      while(!stack.isEmpty()){
        sb.append(stack.pop()).append(" ");
      }

      System.out.println(sb.toString());

//==========================================================================================
    }

// 지워==================================================================================================

    static int N,K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    private static void bfs(){
      Queue<Integer> q = new ArrayDeque<>();
      q.add(N);
      time[N] = 1;

      while(!q.isEmpty()){
        int now = q.poll();
        if(now == K) {
          return;
        }

        for(int i=0; i<3; i++){
          int next;

          if(i==0){
            next = now+1;
          }
          else if(i==1){
            next = now-1;
          }
          else{
            next = now*2;
          }

          if(next<0 || next>100000){
            continue;
          }

          if(time[next] == 0){
            q.add(next);
            time[next] = time[now]+1;
            parent[next] = now;
          }
        }
      }
    }

// 지워==================================================================================================

}