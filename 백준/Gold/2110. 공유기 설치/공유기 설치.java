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

    private static int[] house;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        house = new int[N];
        for(int i=0; i<N; i++){
            house[i] = stoi(br.readLine());
        }

        Arrays.sort(house);

        int lo = 1;
        int hi = house[N-1] - house[0] + 1;

        while(lo<=hi){
            int mid = (lo+hi)/2;

            if(canInstall(mid)<M){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }

        System.out.println(lo-1);
    }

    private static int canInstall(int distance){
        int count = 1;
        int lastLocate = house[0];

        for(int i=1; i<house.length; i++){
            int locate = house[i];
            if(locate - lastLocate >= distance){
                count++;
                lastLocate = locate;
            }
        }

        return count;
    }

}