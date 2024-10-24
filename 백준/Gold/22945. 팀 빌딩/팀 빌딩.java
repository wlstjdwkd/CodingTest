import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

//    private static boolean isArea(int x, int y){
//        return 0<=x && x<N && 0<=y && y<N;
//    }

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = stoi(st.nextToken());
        }

        int result = solve();
        System.out.println(result);
    }

    private static int solve(){
        int left = 1;
        int right = n;
        int result = 0;
        while(left<=right){
            int min = Math.min(arr[left], arr[right]);
            result = Math.max(result, min*(right - left-1));
            if(arr[left]<arr[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return result;
    }

}