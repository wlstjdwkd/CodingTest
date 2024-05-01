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
      String str = br.readLine();
      length = str.length();
      for(int i=0; i<str.length(); i++){
        alphabet[str.charAt(i)-'a']++;
      }
      dfs(0,' ');
      System.out.println(count);

//==========================================================================================
    }

// 지워==================================================================================================
    static int[] alphabet = new int[27];
    static int count;
    static int length;

    static void dfs(int index, char pre){
      if(index == length){
        count++;
        return;
      }

      for(int i=0; i<27; i++){
        if(alphabet[i] == 0){
          continue;
        }

        if(pre != (char) (i+'a')){
          alphabet[i]--;
          dfs(index+1, (char)(i+'a'));
          alphabet[i]++;
        }
      }
    }

// 지워==================================================================================================

}