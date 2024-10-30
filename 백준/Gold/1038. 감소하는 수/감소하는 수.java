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

    private static int n;
    private static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());

        if(n<=10){
            System.out.println(n);
        }
        else if(n>1022){
            System.out.println(-1);
        }
        else{
            for(int i=0; i<10; i++){
                dfs(i,1);
            }

            Collections.sort(list);

            System.out.println(list.get(n));
        }
    }

    private static void dfs(long num, int idx){
        if(idx > 10){
            return;
        }

        list.add(num);
        for(int i=0; i<num%10; i++){
            dfs((num*10) + i , idx+1);
        }
    }

}