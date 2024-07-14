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
        st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        L = stoi(st.nextToken());
        R = stoi(st.nextToken());
        X = stoi(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);
        solve(0,0,0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(answer);

    }

    private static int N, L, R, X, answer;
    private static int[] arr;

    private static void solve(int idx, int cnt, int sum, int max, int min){
        if(cnt>=2){
            if(L <= sum && sum <= R && max -min >=X){
                answer++;
            }
        }

        for(int i=idx; i<N; i++){
            solve(i+1, cnt+1, sum + arr[i], Math.max(max, arr[i]), Math.min(min, arr[i]));
        }
    }
}