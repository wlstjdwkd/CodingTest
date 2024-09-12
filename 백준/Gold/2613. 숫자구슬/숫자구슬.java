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

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        beads = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            beads[i] = stoi(st.nextToken());
            lower = Math.max(lower, beads[i]);
            upper += beads[i];
        }

        binarySearch();
        System.out.println(lower);

        int cnt = 0;
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += beads[i];
            if(sum > lower){
                M--;
                sum = beads[i];
                sb.append(cnt).append(" ");
                cnt = 1;
            }
            else{
                cnt++;
            }

            if(M == N-i){
                break;
            }
        }

        while(M-->0){
            sb.append(cnt).append(" ");
            cnt = 1;
        }
        System.out.println(sb);
    }

    private static int[] beads;
    private static int N,M;
    private static int lower = 0, upper = 0;

    private static void binarySearch(){
        int mid = 0;
        while(lower<=upper){
            mid = (lower + upper)/2;

            int cnt = cntBeadsBundle(mid);
            if(cnt>M){
                lower = mid+1;
            }
            else{
                upper = mid-1;
            }
        }
    }

    private static int cntBeadsBundle(int mid){
        int sum = 0;
        int cnt = 1;

        for(int i=0; i<N; i++){
            sum += beads[i];
            if(sum > mid){
                cnt++;
                sum = beads[i];
            }
        }

        return cnt;
    }

}