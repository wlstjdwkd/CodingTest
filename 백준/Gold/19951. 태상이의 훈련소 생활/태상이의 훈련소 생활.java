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

        int[] ground = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            ground[i] = stoi(st.nextToken());
        }

        int[] groundS = new int[N+1];
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            int k = stoi(st.nextToken());

            groundS[start-1] -= k;
            groundS[end] +=k;
        }

        for(int i=N; i>=1; i--){
            groundS[i -1] += groundS[i];
        }

        for(int i=N; i>=1; i--){
            ground[i] += groundS[i];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            sb.append(ground[i]).append(" ");
        }

        System.out.println(sb);
    }


}