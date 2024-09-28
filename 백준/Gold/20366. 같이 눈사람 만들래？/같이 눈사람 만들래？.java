import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.*;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<n && 0<=y && y<m;
//    }


    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());

        snow = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            snow[i] = stoi(st.nextToken());
        }

        Arrays.sort(snow);

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                int snowMan1 = snow[i] + snow[j];
                int start = 0;
                int end = N -1;

                while(start < end){
                    if(start == i || start == j){
                        start++;
                        continue;
                    }

                    if(end == i || end == j){
                        end--;
                        continue;
                    }

                    int snowMan2 = snow[start] + snow[end];
                    min = Math.min(min, Math.abs(snowMan1 - snowMan2));

                    if(snowMan1 > snowMan2){
                        start++;
                    }
                    else if (snowMan1 < snowMan2){
                        end--;
                    }
                    else{
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(min);
    }

    private static int N;
    private static int[] snow;
    private static int min = Integer.MAX_VALUE;

}