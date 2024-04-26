import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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


    private static int N,M;
    private static List<Integer>[] arr;
    private static boolean isVisited[];
    private static int max;
    private static int cntArr[];


    public static void main(String[] args) throws IOException{
      st = new StringTokenizer(br.readLine());
      N= stoi(st.nextToken());
      M = stoi(st.nextToken());

      isVisited = new boolean[N+1];
      cntArr = new int[N+1];

      arr = new ArrayList[N+1];
      for(int i=0; i<N+1; i++){
        arr[i] = new ArrayList<>();
      }

      for(int i=0; i<M; i++){
        st = new StringTokenizer(br.readLine());
        int a = stoi(st.nextToken());
        int b = stoi(st.nextToken());
        arr[a].add(b);
      }

      for(int i=1; i<N+1; i++){
        isVisited = new boolean[N+1];
//        BFS(i);
        DFS(i);
      }

      for(int i=1; i<N+1; i++){
        if(max<cntArr[i]){
          max = cntArr[i];
        }
      }

      for(int i=1; i<N+1; i++){
        if(max==cntArr[i]){
          sb.append(i).append(" ");
//          System.out.print(i+" ");
        }
      }
      System.out.println(sb);

    }

  static void DFS(int start) {
    isVisited[start] = true;
    for (int i : arr[start]) {
      if (isVisited[i]) continue;
      cntArr[i]++; // i가 해킹할 수 있는 숫자 증가
      DFS(i);
    }
  }

    private static void BFS(int start){
      Queue<Integer> q = new ArrayDeque<>();
      q.add(start);
      isVisited[start] = true;
      while(!q.isEmpty()){
        int now = q.poll();
        for(int i: arr[now]){
          if(isVisited[i]){
            continue;
          }
          cntArr[i]++;
          isVisited[i] = true;
          q.add(i);
        }
      }
    }
}