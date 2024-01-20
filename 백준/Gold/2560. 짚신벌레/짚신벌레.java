import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        dp[0]= 1;
        for(int i=1; i<=N ; i++){
            if(i<a){
                dp[i] = dp[i-1]%1000;
            }
            else if(i<b){
                dp[i] = (dp[i-1] + dp[i-a])%1000;
            }
            else{
                dp[i]= (dp[i-1] + dp[i-a] - dp[i-b]+1000)%1000;
            }
        }

        if(N-d >=0){
            System.out.println((dp[N]-dp[N-d]+1000)%1000);
        }
        else{
            System.out.println(dp[N] % 1000);
        }

    }
}