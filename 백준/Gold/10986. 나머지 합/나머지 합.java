import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long result = 0;
        long[] S = new long[N+1];
        long[] cnt = new long[M];
        st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=N; i++){
            S[i] = Integer.parseInt(st.nextToken());
            S[i] += S[i-1];
            S[i] %= M;
            if(S[i]==0)
                result++;
            cnt[(int)S[i]]++;
        }
        
        for(int i=0; i<M; i++){
            if(cnt[i]>1){
                result += (cnt[i]*(cnt[i]-1))/2;
            }
        }

        System.out.println(result);
    }
}