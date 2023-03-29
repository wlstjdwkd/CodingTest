import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long dp[];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if(N==1||N==2){
            System.out.println(N);
        }
        else{
            dp = new long[N];
            dp[0] = 1;
            dp[1] = 2;

            for(int i=2; i<N;i++){
                dp[i]=dp[i-1]%15746+dp[i-2]%15746;
            }
            System.out.println(dp[N-1]%15746);
        }

    }
}