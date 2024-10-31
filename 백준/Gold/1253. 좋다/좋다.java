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

        int n = stoi(st.nextToken());
        int[] arr = new int[n];

        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            int findNum = arr[i];
            int left = 0;
            int right = n-1;
            int sum = 0;
            while(left < right){

                sum = arr[left] + arr[right];
                if(sum == findNum){
                    if(i==left){
                        left++;
                    }
                    else if(right == i){
                        right--;
                    }
                    else{
                        result++;
                        break;
                    }

                }
                sum = arr[left] + arr[right];

                if(sum > findNum){
                    right--;
                }
                else if(sum < findNum){
                    left++;
                }
            }


        }
        System.out.println(result);
    }

}