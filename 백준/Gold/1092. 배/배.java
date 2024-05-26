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
      List<Integer> crane = new ArrayList<>();

      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++){
        crane.add(stoi(st.nextToken()));
      }

      int M = stoi(br.readLine());
      List<Integer> box = new ArrayList<>();
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<M; i++){
        box.add(stoi(st.nextToken()));
      }

      crane.sort(Collections.reverseOrder());
      Collections.sort(box, Collections.reverseOrder());

      if(crane.get(0) < box.get(0)){
        System.out.println(-1);
        return;
      }

      int day = 0;
      while(!box.isEmpty()){
        int boxIdx = 0, craneIdx = 0;
        while(craneIdx < N){
          if(boxIdx == box.size()){
            break;
          }
          else if(crane.get(craneIdx) >= box.get(boxIdx)){
            box.remove(boxIdx);
            craneIdx++;
          }
          else{
            boxIdx++;
          }
        }
        day++;
      }

      System.out.println(day);


//==========================================================================================
    }

// 지워==================================================================================================



// 지워==================================================================================================

}