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
        M = stoi(st.nextToken());
        N = stoi(st.nextToken());
        L = stoi(st.nextToken());
        range = new int[M];
        points = new Point[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            range[i] = stoi(st.nextToken());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            points[i] = new Point(a, b);
        }

        System.out.println(process());
    }

    private static int process(){
        int res = 0;
        Arrays.sort(range);
        for(int i=0; i<N; i++){
            res += search(i);
        }
        return res;
    }

    private static int search(int idx){
        int start = 0, end = M, mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(mid>=M){
                return 0;
            }

            int dist = getDist(points[idx].x, points[idx].y , range[mid]);
            if(L < dist && points[idx].x < range[mid]){
                end = mid-1;
            }
            else if(L < dist && points[idx].x >= range[mid]){
                start = mid + 1;
            }
            else if(L >= dist){
                return 1;
            }
        }

        return 0;
    }

    private static int getDist(int a, int b, int x){
        return Math.abs(x-a) +  b;
    }

    private static int M, N, L, range[];
    private static Point[] points;

}