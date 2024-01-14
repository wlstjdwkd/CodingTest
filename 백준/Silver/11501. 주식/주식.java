import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                num[j] = Integer.parseInt(st.nextToken());
            }
            int max = num[N-1];
            long answer = 0;

            for(int j=N-2; j>=0; j--){
                if(num[j]<=max){
                    answer += max -num[j];
                }
                else{
                    max = num[j];
                }
            }
            System.out.println(answer);

        }
    }
}