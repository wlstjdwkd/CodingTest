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


    private static class Pair implements Comparable<Pair>{
      int start, end;
      Pair(int start, int end){
        this.start = start;
        this.end = end;
      }

      @Override
      public int compareTo(Pair o ){
        return this.end-o.end;
      }
    }

    private static int N, length;
    private static List<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException{
      st = new StringTokenizer(br.readLine());
      N = stoi(st.nextToken());
      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        int a = stoi(st.nextToken());
        int b = stoi(st.nextToken());
        if(a>b){
          pairs.add(new Pair(b,a));
        }
        else{
          pairs.add(new Pair(a,b));
        }
      }

      length = stoi(br.readLine());

      Collections.sort(pairs);

      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int count = 0, max = 0;
      for(Pair pair: pairs){
        while(!pq.isEmpty() && pq.peek() < pair.end - length){
          pq.poll();
          count--;
        }

        if(pair.start >= pair.end - length){
          count++;
          pq.add(pair.start);
        }

        max = Math.max(max, count);
      }

      System.out.println(max);
    }
}