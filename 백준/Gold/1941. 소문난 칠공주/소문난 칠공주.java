import java.awt.Point;
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {0,1,0,-1};
    private static final int[] dy = {-1,0,1,0};

    private static boolean isArea(int x, int y){
        return 0<=x && x<5 && 0<=y && y<5;
    }
    private static char[][] map;
    private static int answer;
    private static boolean[] visited;
    private static int[] selected = new int[7];

    public static void main(String[] args) throws IOException{

        map = new char[5][5];
        for(int i=0; i<5; i++){
            map[i] = br.readLine().toCharArray();
        }

        backtracking(0,0,0);

        System.out.println(answer);
    }

    private static void backtracking(int depth, int numY, int start){
        if(numY >=4){
            return;
        }

        if(depth == 7){
            visited = new boolean[7];
            bfs();
            return;
        }

        for(int i=start; i<25; i++){
            selected[depth] = i;
            if(map[i/5][i%5] == 'Y'){
                backtracking(depth+1, numY+1, i+1);
            }
            else{
                backtracking(depth+1, numY, i+1);
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {selected[0]/5, selected[0]%5});
        visited[0] = true;
        int conn = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for(int i=0; i<4; i++){
                int nr = r+dx[i];
                int nc = c+dy[i];
                int ni = nr*5 + nc;

                if(isArea(nr, nc)){
                    for(int j=0; j<7; j++){
                        if(!visited[j]){
                            if(selected[j] == ni){
                                q.add(new int[] {nr,nc});
                                visited[j] = true;
                                conn++;
                            }
                        }
                    }
                }
            }
        }

        if(conn == 7){
            answer++;
        }
    }

}