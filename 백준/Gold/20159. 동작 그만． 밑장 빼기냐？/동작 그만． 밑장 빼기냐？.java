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
      st = new StringTokenizer(br.readLine());
      int[] evenSum = new int[N/2];
      int[] oddSum = new int[N/2];
      int z = 2;

      oddSum[0] = stoi(st.nextToken());
      evenSum[0] = stoi(st.nextToken());

      if(N==2){
        System.out.println(Math.max(evenSum[0], oddSum[0]));
      }
      else{
        for(int i=2; i<N; i++){
          if(i%2 == 0){
            oddSum[i/2] += oddSum[i-z] + stoi(st.nextToken());
            z++;
          }
          else{
            evenSum[i/2] += evenSum[i-z] + stoi(st.nextToken());
          }
        }

        int result = evenSum[N/2-1];

        for(int i=0; i<N/2; i++){
          int temp = oddSum[i] + (evenSum[N/2 -1] - evenSum[i]);
          if(temp> result){
            result = temp;
          }
        }

        if(result < oddSum[0] + evenSum[N/2 - 2]){
          result = oddSum[0] + evenSum[N/2 -2];
        }

        for(int i=0; i<N/2-1; i++){
          int temp = evenSum[N/2-2] -evenSum[i] + oddSum[i+1];
          if(temp>result){
            result = temp;
          }
        }

        System.out.println(result);
      }



//==========================================================================================
    }

// 지워==================================================================================================



// 지워==================================================================================================

}