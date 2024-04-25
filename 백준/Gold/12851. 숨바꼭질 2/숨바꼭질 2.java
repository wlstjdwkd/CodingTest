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
  static int N, K;
  static int[] time = new int[100001];
  static int minTime = 987654321;
  static int count = 0;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = stoi(st.nextToken());
      K = stoi(st.nextToken());

      if(N>=K){
        System.out.println((N-K) + "\n1");
        return;
      }

      bfs();
      System.out.println(minTime+"\n" + count);

    }
    public static void bfs(){
      Queue<Integer> q = new ArrayDeque<>();

      q.add(N);
      time[N] = 1;
      while(!q.isEmpty()){
        int now = q.poll();

        if(minTime<time[now]){
          return;
        }

        for(int i=0; i<3; i++){
          int next;
          switch(i){
            case 0 :
              next = now+1;
              break;

            case 1:
              next = now-1;
              break;

            default:
              next = now*2;
              break;
          }

          if(next<0 || next>100000){
            continue;
          }

          if(next == K){
            minTime = time[now];
            count++;
          }

          if(time[next] == 0 || time[next] == time[now] + 1){
            q.add(next);
            time[next] = time[now]+1;
          }

        }
      }
    }
}