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
//        return 0<= x && x<n && 0<=y && y<n;
//    }

    public static void main(String[] args) throws IOException {
        int n = stoi(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = stoi(st.nextToken());
            arr[i][1] = stoi(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> e2[1] - e1[1]);

        int lastEndPoint = arr[0][1];

        for(int i=0; i<n; i++){
            if(arr[i][1] <= lastEndPoint){
                lastEndPoint = arr[i][1] - arr[i][0];
            }
            else{
                lastEndPoint -= arr[i][0];
            }
        }

        System.out.println(lastEndPoint);
    }


}