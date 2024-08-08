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
        minDp = new long[101];
        maxDp = new String[101];

        Arrays.fill(minDp, Long.MAX_VALUE);
        N = stoi(br.readLine());
        minDp[2]=1;
        minDp[3]=7;
        minDp[4]=4;
        minDp[5]=2;
        minDp[6]=6;
        minDp[7]=8;
        minDp[8]=10;

        String[] add = {"1", "7", "4", "2", "0", "8"};

        for(int i=9; i<=100; i++){
            for(int j=2; j<=7; j++){
                String line = minDp[i-j] + add[j-2];
                minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
            }
        }

//        maxDp[2] = "1";
//        maxDp[3] = "7";
//        maxDp[4] = "11";
//        maxDp[5] = "71";
//        maxDp[6] = "111";
//        maxDp[7] = "8";
        for(int i=2; i<=100; i++){
            String line = "";
            if(i%2 == 0){
                for(int k=0; k<i/2; k++){
                    line +="1";
                }
            }
            else{
                line += "7";
                for(int k=1; k<i/2; k++){
                    line+="1";
                }
            }
            maxDp[i] = line;
        }

        for(int i=0; i<N; i++){
            M = stoi(br.readLine());
            System.out.println(minDp[M] + " "+ maxDp[M]);
        }
    }

    private static int N;
    private static long[] minDp;
    private static String[] maxDp;
    private static int M;


}