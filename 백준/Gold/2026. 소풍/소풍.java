import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
      return Integer.parseInt(s);
    }
    static int[][] arr;
    static boolean[] visited;
    static int k, n, f;
    static boolean done = false;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st= new StringTokenizer(br.readLine());
      k = stoi(st.nextToken());
      n = stoi(st.nextToken());
      f = stoi(st.nextToken());

      arr = new int[n+1][n+1];
      visited = new boolean[n+1];
      sb = new StringBuilder();

      int[] indegree = new int[n+1];

      for(int i=0; i<f; i++){
        st = new StringTokenizer(br.readLine());
        int v1 = stoi(st.nextToken());
        int v2 = stoi(st.nextToken());

        arr[v1][v2] = arr[v2][v1] = 1;
        indegree[v1]++;
        indegree[v2]++;
      }

      for(int i=1; i<=n; i++){
        if(indegree[i] < k-1){
          continue;
        }
        if(done){
          break;
        }

        visited[i] = true;
        dfs(i,1);
        visited[i] = false;
      }

      if(!done){
        System.out.println(-1);
      }
      else{
        System.out.println(sb);
      }
    }

    private static void dfs(int now, int depth){
      if(done){
        return;
      }

      if(depth==k){
        print();
        done = true;
        return;
      }

      for(int i=now+1; i<=n; i++){
        if(arr[now][i] == 1 && isFriend(i)){
          visited[i] = true;
          dfs(i, depth+1);
          visited[i] = false;
        }
      }
    }

    static boolean isFriend(int target){
      for(int i =1; i<=n; i++){
        if(visited[i] && arr[target][i] != 1){
          return false;
        }
      }
      return true;
    }

    static void print(){
      for(int i=1; i<=n; i++){
        if(visited[i]){
          sb.append(i+"\n");
        }
      }
    }

}