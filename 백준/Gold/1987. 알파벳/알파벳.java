import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static int r,c;
    private static int[][] board;
    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};
    private static int max = 0;
    private static boolean[] alpha;


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        r = stoi(st.nextToken());
        c = stoi(st.nextToken());

        board = new int[r][c];
        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                board[i][j] = s.charAt(j) - 'A';
            }
        }

        alpha = new boolean[26];
        backTracing(0,0,1);
        System.out.println(max);
    }

    private static void backTracing(int x, int y, int depth){
        alpha[board[x][y]] = true;
        max = Math.max(max, depth);

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isArea(nx,ny)){
                if(!alpha[board[nx][ny]]){

                    backTracing(nx,ny,depth+1);
                    alpha[board[nx][ny]] = false;
                }
            }
        }
    }

    private static boolean isArea(int x, int y){
        return 0<=x && x<r && 0<=y && y<c;
    }

}