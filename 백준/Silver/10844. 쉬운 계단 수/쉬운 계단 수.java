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
      
      long[][] dp = new long[N+1][10];
      for(int i=1; i<10; i++){
        dp[1][i] = 1;
      }
      
      for(int i=2; i<=N; i++){
        for(int j=0; j<10; j++){
          if(j==0){
            dp[i][0] = dp[i-1][1] % mod;
          }
          else if(j == 9){
            dp[i][9] = dp[i-1][8] %mod;
          }
          else{
            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
          }
        }
      }
      
      long result = 0;
      
      for(int i=0; i<10; i++){
        result += dp[N][i];
      }

      System.out.println(result %mod);
      
//==========================================================================================
    }

// 지워==================================================================================================
    static final long mod = 1000000000;
    
// 지워==================================================================================================

}