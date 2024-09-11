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
//        return 0<= x && x<n && 0<=y && y<m;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arr[i] = stoi(st.nextToken());
        }

        if(n<=m){
            System.out.println(n);
            return;
        }

        long time = binarySearch() -1;
        long child = m;
        for(int i=0; i<m; i++){
            child += time/arr[i];
        }

        int leftChild = n - (int)child;
        int cnt = 0;
        int i=0;

        while(true){
            if(((time+1)/arr[i]) != (time /arr[i])){
                cnt++;
            }
            i++;

            if(cnt == leftChild){
                break;
            }
        }
        System.out.println(i);

    }

    private static long binarySearch(){
        long left = 0;
        long right = 2000000000L * 30L;
        long result = -1;

        while(left <= right){
            long mid = (left + right) / 2;
            long child = m;

            for(int i=0; i<m; i++){
                child += mid/arr[i];
            }

            if(child >= n){
                result = mid;
                right = mid-1;
            }
            else if(child < n){
                left = mid+1;
            }
        }
        return result;
    }

    private static int n,m;
    private static int[] arr;



}