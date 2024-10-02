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
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int d = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int c = stoi(st.nextToken());
        int[] A = new int[N];
        int[] check = new int[d+1];

        for(int i=0; i<N; i++){
            A[i] = stoi(br.readLine());
        }

        int res = 1;
        check[c]++;

        for(int i=0; i<k; i++){
            if(check[A[i]] == 0){
                res++;
            }
            check[A[i]]++;

        }

        int cnt = res;

        for(int i=1; i<N; i++){
            int pop = A[i-1];
            check[pop]--;
            if(check[pop] == 0){
                cnt--;
            }

            int add = A[(i+k-1) % N];
            if(check[add] == 0){
                cnt++;
            }
            check[add]++;

            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }


}