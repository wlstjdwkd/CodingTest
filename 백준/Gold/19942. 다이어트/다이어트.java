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
//        return 0<=x && x<5 && 0<=y && y<5;
//    }

    private static int N, M = 5, ans = Integer.MAX_VALUE;
    private static int[][] nutrients;
    private static int[] minN;
    private static int[] select;

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        N = stoi(br.readLine());

        nutrients = new int[N][M];
        minN = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            minN[i] = stoi(st.nextToken());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                nutrients[i][j] = stoi(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            select = new int[N];
            choice(0,i,0);
        }

        if(list.size()>0){
            System.out.println(ans);
            Collections.sort(list);
            String str1 = list.get(0);
            for(int i=0; i<str1.length(); i++){
                System.out.print(str1.charAt(i));
            }
        }
        else{
            System.out.println(-1);
        }
    }

    private static void choice(int cnt, int sel, int start){
        if(cnt == sel){
            isCheck(sel);
            return;
        }

        for(int i=start; i<N; i++){
            select[cnt] = i;
            choice(cnt+1, sel, i+1);
        }
    }

    private static boolean isCheck(int sel){
        int price = 0;
        int[] sum = new int[4];
        for(int i=0; i<sel; i++){
            sum[0] += nutrients[select[i]][0];
            sum[1] += nutrients[select[i]][1];
            sum[2] += nutrients[select[i]][2];
            sum[3] += nutrients[select[i]][3];
            price += nutrients[select[i]][4];
        }

        for(int i=0; i<4; i++){
            if(minN[i] > sum[i]){
                return false;
            }
        }

        if(ans>=price){
            if(ans>price){
                list.clear();
            }

            String str = "";
            for(int i=0; i<sel; i++){
                str+=(select[i] + 1 + " ");
            }
            list.add(str);
            ans = price;
        }

        return true;
    }

}