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
//        return 0<= x && x<N && 0<=y && y<N;
//    }

    public static void main(String[] args) throws IOException {
        int n = stoi(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = stoi(st.nextToken());
        }

        int s = stoi(br.readLine());

        if(n*(1+n)/2 <s){
            Arrays.sort(arr);
            printAnswer(n,arr, true);
            return;
        }

        for(int k=0; k<n && s>0; k++){
            int max = arr[k];
            int idx = -1;
            for(int i=k+1; i<n && i<=k+s; i++){
                if(arr[i] > max){
                    max = arr[i];
                    idx = i;
                }
            }

            if(idx == -1){
                continue;
            }

            s-= idx-k;
            for(int i=idx; i>=k+1; i--){
                int tmp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = tmp;
            }


        }

        printAnswer(n,arr, false);
    }

    private static void printAnswer(final int n, final int[] arr, final boolean reverse){
        if(reverse){
            for(int i=n-1; i>=0; i--){
                sb.append(arr[i]).append(' ');
            }
        }
        else{
            for(int i=0; i<n; i++){
                sb.append(arr[i]).append(' ');
            }
        }

        System.out.println(sb);
    }




}