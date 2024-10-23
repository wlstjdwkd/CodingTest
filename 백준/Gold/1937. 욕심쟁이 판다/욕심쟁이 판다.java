import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

    private static boolean isArea(int x, int y){
        return 0<=x && x<N && 0<=y && y<N;
    }

    private static int N;
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ans = Math.max(ans, DFS(i,j));
            }
        }

        System.out.println(ans);

    }

    private static int DFS(int i, int j){
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        dp[i][j] = 1;
        for(int k=0; k<4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(isArea(nx,ny)){
                if(map[i][j] < map[nx][ny]){
                    dp[i][j] = Math.max(dp[i][j], DFS(nx,ny) + 1);

                }
            }
        }

        return dp[i][j];
    }

}