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
//        return 0<=x && x<m && 0<=y && y<n;
//    }



    public static void main(String[] args) throws IOException{

        int n = stoi(br.readLine());

        getResult(0,n);
        System.out.println(sb);

    }

    private static void getResult(int output, int n){
        if(n == 0){
            sb.append(output).append("\n");
            return;
        }

        for(int i=0; i<10; i++){
            int next = output*10 + i;
            if(isPrime(next)){
                getResult(next, n-1);
            }
        }
    }

    private static boolean isPrime(int num){
        if(num < 2){
            return false;
        }

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

}