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



    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int h = stoi(st.nextToken());

        int[] down = new int[n/2];
        int[] up = new int[n/2];
        for(int i=0; i<n/2; i++){
            int a = stoi(br.readLine());
            int b = stoi(br.readLine());

            down[i] = a;
            up[i] = b;
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = n;
        int cnt = 0;

        for(int i=1; i<h+1; i++){
            int conflict = binarySearch(0, n/2, i, down) + binarySearch(0, n/2, h-i+1, up);
            if(min == conflict){
                cnt++;
            }
            else if(min> conflict){
                min = conflict;
                cnt = 1;
            }
        }

        System.out.println(min + " " + cnt);

    }

    private static int binarySearch(int left, int right, int h, int[] arr){
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= h){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return arr.length - right;
    }


}