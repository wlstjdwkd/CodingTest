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

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N= Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
      PriorityQueue<Integer> minPQ = new PriorityQueue<>();

      for(int i=0; i<N; i++){
        int a = Integer.parseInt(br.readLine());
        if(maxPQ.size() == minPQ.size()){
          maxPQ.add(a);
          if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()){
            minPQ.add(maxPQ.poll());
            maxPQ.add(minPQ.poll());
          }
        }
        else{
          minPQ.add(a);
          if(maxPQ.peek()>minPQ.peek()){
            minPQ.add(maxPQ.poll());
            maxPQ.add(minPQ.poll());
          }
        }
        sb.append(maxPQ.peek()).append("\n");
        
      }
      System.out.println(sb);
    }
}