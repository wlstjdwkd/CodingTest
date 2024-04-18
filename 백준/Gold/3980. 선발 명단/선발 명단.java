import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    static int[][] position = new int[11][11];
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int C = Integer.parseInt(br.readLine());
        for(int tc =0; tc<C; tc++){
            for(int i=0; i<11; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<11; j++){
                    position[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;
            visited = new boolean[11];
            backtracking(0, 0);
            System.out.println(max);

        }
    }

    private static void backtracking(int cnt, int sum){
        if(cnt == 11){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<11; i++){
            if(position[cnt][i] == 0 || visited[i]) continue;
            visited[i] = true;
            backtracking(cnt+1, sum+position[cnt][i]);
            visited[i] = false;
        }
    }
}