import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<N && 0<=y && y<M;
//    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());

        int[] boards = new int[N+1];
        
        int sum = 0;
        for(int i=0; i<N; i++){
            int n = stoi(br.readLine());
            boards[i] = n;
            sum+=n;
        }
        
        int start = 0;
        int last = 0;
        int result = 0;
        
        int now = boards[start];
        
        while(start<=last && last<N){
            int minNow = Math.min(now, sum-now);
            
            result = Math.max(result, minNow);
            
            if(now == minNow){
                last++;
                now+=boards[last];
            }
            else{
                now -= boards[start];
                start++;
            }
        }

        System.out.println(result);
    }


}