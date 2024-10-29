import java.awt.Point;
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

//    private static boolean isArea(int x, int y){
//        return 0<=x && x<m && 0<=y && y<n;
//    }

    private static int N,M;
    private static int[][] map;

    private static List<Point> person;
    private static List<Point> chicken;
    private static int ans;
    private static boolean[] open;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][N];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = stoi(st.nextToken());

                if(map[i][j] == 1){
                    person.add(new Point(i, j));
                }
                else if(map[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        dfs(0,0);

        System.out.println(ans);

    }

    private static void dfs(int start, int depth){
        if(depth == M){
            int res = 0;
            for(int i=0; i<person.size(); i++){
                int temp = Integer.MAX_VALUE;

                for(int j=0; j<chicken.size(); j++) {
                    if(open[j]){
                        int distance =
                                Math.abs(person.get(i).x - chicken.get(j).x) + Math.abs(person.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }

                }

                res+=temp;
            }

            ans = Math.min(ans, res);
            return;
        }

        for(int i = start; i<chicken.size(); i++){
            open[i] = true;
            dfs(i+1, depth+1);
            open[i] = false;
        }


    }



}