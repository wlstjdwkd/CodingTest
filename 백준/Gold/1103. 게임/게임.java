import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
        return 0<=x && x<m && 0<=y && y<n;
    }

    private static int n,m,max;
    private static boolean isCycle = false;
    private static int[][] dp;
    private static char[][] map;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        dp = new int[n][m];
        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        visited[0][0] = true;
        dfs(0,0,1);
        if(isCycle){
            System.out.println(-1);
        }
        else{
            System.out.println(max);
        }
    }

    private static void dfs(int x, int y, int moveCnt){
        int moveSquareCnt = map[y][x] - '0';
        dp[y][x] = moveCnt;
        if(moveCnt > max){

            max = moveCnt;
        }

        for(int i=0; i<4; i++){
            int nx = x + moveSquareCnt * dx[i];
            int ny = y + moveSquareCnt * dy[i];

            if(isArea(nx, ny)){
                if(map[ny][nx] != 'H'){
                    if(moveCnt >= dp[ny][nx]){
                        if(visited[ny][nx]){
                            isCycle = true;
                            return;
                        }
                        visited[ny][nx] = true;
                        dfs(nx, ny, moveCnt + 1);
                        visited[ny][nx] = false;
                    }
                }
            }
        }
    }


}