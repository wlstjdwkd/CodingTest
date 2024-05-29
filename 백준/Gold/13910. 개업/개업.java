import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n;
    static final int MAX = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] works = new int[MAX];
        int[] dp = new int[n+1];

        Arrays.fill(dp, MAX);
        dp[0] = 0;
        works[0] = 1;

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for( int i=0; i<m; i++){
            works[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <= i/2; j++) {
                if((j==i-j && works[j] >=2)){
                    dp[i] = 1;
                }
                else if(j!=i-j &&works[j] >0 && works[i-j]>0){
                    dp[i] = 1;
                }
                else if(dp[j] != MAX &&dp[i-j]!=MAX){
                    dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
                }
            }
        }

        dp[n] = (dp[n] >= MAX ? -1 : dp[n]);
        System.out.println(dp[n]);
    }
}