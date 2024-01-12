import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T= Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] home = new int[N];

            int total = 0;
            for(int j=0; j<N; j++){
                home[j] = Integer.parseInt(st.nextToken());
                total += home[j];
            }

            if(N==M){
                if(total<K){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else{
                int count = 0;
                int start = 0;
                int end = M-1;
                int sum=0;
                for(int j=0; j<=end; j++){
                    sum += home[j];
                }
                while(start < N){
                    if(sum<K){
                        count++;
                    }
                    sum -= home[start++];
                    sum += home[(++end)%N];
                }
                System.out.println(count);
            }
        }
    }
}