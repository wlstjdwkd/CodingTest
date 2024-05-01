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
      N = stoi(br.readLine());
      List<Integer> list = new LinkedList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++){
        list.add(stoi(st.nextToken()));
      }
      charge(list,0);
      System.out.println(max);

//==========================================================================================
    }

// 지워==================================================================================================
    static int N;
    static int max = Integer.MIN_VALUE;

    static void charge(List<Integer> list, int sum){
      if(list.size()==2){
        max = Math.max(max,sum);
      }
      for(int i=1; i<list.size()-1; i++){
        int tmp = list.get(i);
        int chargeValue = list.get(i-1) * list.get(i+1);
        list.remove(i);
        charge(list, sum+chargeValue);
        list.add(i, tmp);
      }
    }
// 지워==================================================================================================

}