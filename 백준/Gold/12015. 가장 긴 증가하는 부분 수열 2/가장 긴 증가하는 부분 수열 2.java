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


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] seq = new int[N];
        List<Integer> LIS = new ArrayList<>();

        for(int i=0;i<N;i++){
            seq[i] = stoi(st.nextToken());
        }

        LIS.add(seq[0]);

        for(int i=1; i<N; i++){
            int key = seq[i];

            if(LIS.get(LIS.size()-1) < key){

                LIS.add(key);
            }
            else{
                int lo = 0;
                int hi = LIS.size()-1;
                while(lo <= hi){
                    int mid = (lo + hi)/2;

                    if(LIS.get(mid) < key){
                        lo = mid + 1;
                    }
                    else{
                        hi = mid - 1;
                    }
                }


                LIS.set(lo, key);
            }
        }

        System.out.println(LIS.size());
    }

}