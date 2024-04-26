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

    public static void main(String[] args) throws IOException{
//===========================================================================================
      st = new StringTokenizer(br.readLine());
      n = stoi(st.nextToken());
      m = stoi(st.nextToken());
      sight = new boolean[n];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        int flag = stoi(st.nextToken());
        if(flag == 1){
          sight[i] = true;

        }
      }

      list = new ArrayList[n];
      dist = new long[n];
      for(int i=0; i<n; i++){
        list[i] = new ArrayList<>();
        dist[i] = Long.MAX_VALUE;
      }

      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        int s = stoi(st.nextToken());
        int e = stoi(st.nextToken());
        int c = stoi(st.nextToken());

        list[s].add(new Node(e,c));
        list[e].add(new Node(s,c));
      }

      dist[0] = 0;
      dijkstra();
      System.out.println(dist[n-1] == Long.MAX_VALUE ? -1 : dist[n-1]);
    }

    private static void dijkstra(){
      PriorityQueue<Node> q = new PriorityQueue<>();
      boolean[] visited = new boolean[n];
      q.add(new Node(0,0));

      while(!q.isEmpty()){
        Node current = q.poll();

        if(!visited[current.node]){
          visited[current.node] = true;
          for(int i=0; i<list[current.node].size(); i++){
            Node next = list[current.node].get(i);
            if(next.node != n-1 && sight[next.node]){
              continue;
            }
            if(dist[next.node] > dist[current.node] + next.cost){
              dist[next.node] = dist[current.node] + next.cost;
              q.add(new Node(next.node, dist[next.node]));
            }
          }
        }
      }
    }
    private static int n,m;
    private static boolean[] sight;
    private static List<Node>[] list;
    private static long[] dist;

    private static class Node implements Comparable<Node>{
      int node;
      long cost;
      public Node(int node, long cost){
        this.node = node;
        this.cost = cost;
      }

      @Override
      public int compareTo(Node n){
        if(this.cost - n.cost > 0){
          return 1;
        }
        else{
          return -1;
        }
      }
    }

//===========================================================================================

}