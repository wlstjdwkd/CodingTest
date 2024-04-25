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
    private static int n;
    private static int[] numArr;
    private static int[] openArr = new int[4];
    private static long max = Long.MIN_VALUE;
    private static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      numArr = new int[n];

      for(int i=0; i<n; i++){
        numArr[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());

      for(int i=0; i<4; i++){
        openArr[i] = Integer.parseInt(st.nextToken());
      }

      dfs(1, numArr[0]);
      System.out.println(max);
      System.out.println(min);

    }

    private static void dfs(int cnt, long res){
      if(cnt == n){
        max = Math.max(res, max);
        min = Math.min(res, min);
        return;
      }

      for(int i=0; i<4; i++){
        if(openArr[i] > 0){
          openArr[i]--;
          switch(i){
            case 0:
              dfs(cnt+1, res+numArr[cnt]);
              break;

            case 1:
              dfs(cnt+1, res - numArr[cnt]);
              break;

            case 2:
              dfs(cnt+1, res* numArr[cnt]);
              break;

            case 3:
              dfs(cnt+1, res/numArr[cnt]);
              break;
          }
          openArr[i]++;
        }
      }
    }
}