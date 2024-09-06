import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isArea(int x, int y){
        return 0<= x && x<n && 0<=y && y<m;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = stoi(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j] = true;
                solve(i,j,arr[i][j],1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void solve(int row, int col, int sum, int count){
        if(count == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int curRow = row + dx[i];
            int curCol = col + dy[i];

            if(isArea(curRow, curCol)){
                if(!visit[curRow][curCol]){
                    if(count == 2){
                        visit[curRow][curCol] = true;
                        solve(row, col, sum + arr[curRow][curCol], count + 1);
                        visit[curRow][curCol] = false;
                    }
                    visit[curRow][curCol] = true;
                    solve(curRow, curCol, sum + arr[curRow][curCol], count + 1);
                    visit[curRow][curCol] = false;
                }
            }
        }
    }

    private static int max = Integer.MIN_VALUE;
    private static int[][] arr;
    private static boolean[][] visit;
    private static int n,m;

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};



}