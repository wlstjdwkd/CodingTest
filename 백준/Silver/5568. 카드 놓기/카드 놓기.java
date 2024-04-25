import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
    public static int NUMBER_OF_CARD;
    public static int NUMBER_OF_SECRET;
    public static String card[];
    public static boolean[] visited;
    public static Set<String> hs = new HashSet<>();

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      NUMBER_OF_CARD = stoi(br.readLine());
      NUMBER_OF_SECRET =stoi(br.readLine());
      card = new String[NUMBER_OF_CARD];
      for(int i=0; i<NUMBER_OF_CARD; i++){
        card[i] = br.readLine();
      }

      visited = new boolean[NUMBER_OF_CARD];
      selectCard(NUMBER_OF_SECRET, "");
      System.out.println(hs.size());
    }

    public static void selectCard(int remain, String k){
      if(remain == 0){
        hs.add(k);
        return;
      }
      for(int i=0; i<NUMBER_OF_CARD; i++){
        if(!visited[i]){
          visited[i] = true;
          selectCard(remain-1, k+card[i]);
          visited[i] = false;
        }
      }
    }
}