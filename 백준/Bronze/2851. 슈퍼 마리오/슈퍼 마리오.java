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
      int[] arr = new int[11];
      for(int i=1; i<=10; i++){
        arr[i]= arr[i-1] + stoi(br.readLine());
      }
      int dif = Integer.MAX_VALUE;
      int answer = 0;
      for(int i=10; i>0; i--){
        int temp = Math.abs(100-arr[i]);
        if(dif> temp){
          dif = temp;
          answer = arr[i];
        }
      }

      System.out.println(answer);
//==========================================================================================
    }

// 지워==================================================================================================

// 지워==================================================================================================

}