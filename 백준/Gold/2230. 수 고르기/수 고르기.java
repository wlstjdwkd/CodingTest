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


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = stoi(br.readLine());
        }

        Arrays.sort(arr);

        int i = 0;
        int j=0;
        int ans = Integer.MAX_VALUE;

        while(i < N){
            if(arr[i] - arr[j] < M){
                i++;
                continue;
            }

            if(arr[i] - arr[j] == M){
                ans = M;
                break;
            }

            ans = Math.min(ans, arr[i] - arr[j]);
            j++;
        }

        System.out.println(ans);

    }
}