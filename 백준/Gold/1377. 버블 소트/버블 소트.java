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

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<h && 0<=y && y<w;
//    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());

        Point[] points = new Point[N+1];
        for(int i=1; i<=N; i++){
            int temp = stoi(br.readLine());
            points[i] = new Point(temp,i);
        }

        Arrays.sort(points, 1, N+1);

        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, points[i].idx - i);
        }

        System.out.println(max+1);
    }

    private static class Point implements Comparable<Point> {
        int num;
        int idx;
        public Point(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point o) {
            return num - o.num;
        }
    }



}