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
      st = new StringTokenizer(br.readLine());
      int n = stoi(st.nextToken());
      int x = stoi(st.nextToken());
      
      int[] arr = new int[n];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        arr[i] = stoi(st.nextToken());
      }
      
      int sum = 0;
      for(int i=0; i<x; i++){
        sum+= arr[i];
      }
      int max = sum;
      int maxCnt = 1;
      for(int i=x; i<n; i++){
        sum +=arr[i] - arr[i-x];
        if(max == sum){
          maxCnt++;
        }
        else if(max<sum){
          max = sum;
          maxCnt = 1;
        }
      }
      if(max == 0){
        System.out.println("SAD");
        return;
      }
      System.out.println(max);
      System.out.println(maxCnt);
      
//==========================================================================================
    }

// 지워==================================================================================================


// 지워==================================================================================================

}