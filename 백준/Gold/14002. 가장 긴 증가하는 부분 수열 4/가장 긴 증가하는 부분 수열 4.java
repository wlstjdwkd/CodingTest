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


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = stoi(st.nextToken());
        }
        int[] dp = new int[n];
        int max = 1;


        for(int i=0; i<n; i++){
            int x = arr[i];
            if(dp[i] == 0){
                dp[i] = 1;
            }
            for(int j=i+1; j<n; j++){
                int y = arr[j];
                if(x<y){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    max = Math.max(max, dp[j]);
                }
            }
        }


        sb.append(max).append("\n");
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--){
            if(max == dp[i]){
                stack.push(arr[i]);
                max--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

    }

}