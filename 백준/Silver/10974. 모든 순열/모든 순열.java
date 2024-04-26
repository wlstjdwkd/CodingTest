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


    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = stoi(br.readLine());

      int[] arr = new int[n];
      int[] output = new int[n];

      boolean[] visited = new boolean[n];
      for(int i=0; i<n; i++){
        arr[i] = i+1;
      }

      perm(arr, output, visited, 0, n);
    }

    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n){
      if(depth==n){
        print(output, n);
        return;
      }

      for(int i=0; i<n; i++){
        if(!visited[i]){
          visited[i] = true;
          output[depth] = arr[i];
          perm(arr, output, visited, depth+1, n);
          visited[i] = false;
        }
      }
    }

    private static void print(int[] arr, int r){
      for(int i=0; i<r; i++){
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
}