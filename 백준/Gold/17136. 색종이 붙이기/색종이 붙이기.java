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

//    private static boolean isArea(int x, int y){
//        return 0<=x && x<m && 0<=y && y<n;
//    }

    private static int[][] map;
    private static int[] paper = {0,5,5,5,5,5};
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{

        map = new int[10][10];
        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        dfs(0,0, 0);

        if(ans == Integer.MAX_VALUE) ans = -1;

        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt){
        if(x>=9 && y>9){
            ans = Math.min(ans, cnt);
            return;
        }

        if(cnt >= ans){
            return;
        }

        if(y>9){
            dfs(x+1,0, cnt);
            return;
        }

        if(map[x][y] == 1){
            for(int i=5; i>=1; i--){
                if(paper[i] > 0 && isAttach(x,y,i)){
                    attach(x,y, i, 0);
                    paper[i]--;
                    dfs(x,y+1, cnt+1);
                    attach(x, y, i, 1);
                    paper[i]++;
                }
            }
        }
        else{
            dfs(x,y+1, cnt);
        }
    }

    private static void attach(int x, int y, int cnt, int state){
        for(int i=x; i<x+cnt; i++){
            for(int j=y; j<y+cnt; j++){
                map[i][j] = state;
            }
        }
    }

    private static boolean isAttach(int x, int y, int cnt){
        for(int i=x; i< x+ cnt; i++){
            for(int j = y; j< y + cnt; j++){
                if(i<0 || i>=10 || j<0 || j>=10){
                    return false;
                }

                if(map[i][j] == 0){
                    return false;
                }
            }
        }

        return true;
    }

}