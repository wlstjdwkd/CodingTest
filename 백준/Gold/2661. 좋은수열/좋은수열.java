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
    private static final int start = 1;
    private static final int end = 3;
    private static int n;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());

        backtracking("");

    }

    private static void backtracking(String s){
        if(s.length() == n){
            System.out.println(s);
            System.exit(0);
        }

        for(int i = start; i <= end; i++){
            if(canMake(s+i)){
                backtracking(s+i);
            }
        }
    }

    private static boolean canMake(String s){
        for(int i=1; i<=s.length()/2; i++){
            String front = s.substring(s.length() - i*2, s.length() - i);
            String end = s.substring(s.length() - i);
            if(front.equals(end)){
                return false;
            }
        }

        return true;
    }

}