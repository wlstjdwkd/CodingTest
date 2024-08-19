import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

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
//        return 0<= x && x<R && 0<=y && y<C;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int L = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+2];
        arr[0] = 0;

        for(int i = 1; i <= N; i++){
            arr[i] = stoi(st.nextToken());
        }

        arr[N+1] = L;
        Arrays.sort(arr);

        int left = 1;
        int right = L-1;

        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            for(int i=1; i<arr.length; i++){
                sum += (arr[i] - arr[i-1] -1)/mid;
            }

            if(sum>M){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(left);
    }


}