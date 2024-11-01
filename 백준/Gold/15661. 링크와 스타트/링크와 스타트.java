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
import org.w3c.dom.Node;

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
//        return 0<=x && x<n && 0<=y && y<n;
//    }

    private static int[][] map;
    private static int n, answer, t;
    private static boolean[] v;

    public static void main(String[] args) throws IOException{

        n = stoi(br.readLine());
        map = new int[n][n];
        v = new boolean[n];
        answer = Integer.MAX_VALUE;
        t = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        for(t=1; t<=n/2; t++){
            nCr(0,0);
        }

        System.out.println(answer);
    }

    private static void nCr(int depth, int start){
        if(depth == t){
            answer = Math.min(answer,diff());

            if(answer == 0){
                System.out.println(0);
                System.exit(0);
            }

            return;
        }

        for(int i=start; i<n; i++){
            if(!v[i]){
                v[i] = true;
                nCr(depth+1, i+1);
                v[i] = false;
            }
        }
    }

    private static int diff(){
        int start = 0;
        int link = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(v[i] && v[j]){
                    start += (map[i][j] + map[j][i]);
                }
                else if(!v[i] && !v[j]){
                    link += (map[i][j] + map[j][i]);
                }
            }
        }

        return Math.abs(start - link);
    }


}