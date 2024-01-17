import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Coin{
        int value;
        int quantity;
        public Coin(int value, int quantity){
            this.value=value;
            this.quantity=quantity;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=3;
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            Coin[] coins = new Coin[n+1];
            boolean[] dp = new boolean[100_001];
            int total = 0;
            for(int i=1; i<=n;i++){
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(value, quantity);

                total += value*quantity;

                for(int j=1; j<=quantity; j++){
                    dp[value*j]=true;
                }
            }

            if(total%2==1){
                System.out.println(0);
                continue;
            }
            else if (dp[total/2]){
                System.out.println(1);
                continue;
            }
            dp[0]=true;

            for(int i= 1; i<=n; i++){
                int v = coins[i].value;
                int q = coins[i].quantity;

                for(int j= total/2; j>=v; j--){
                    if(dp[j-v]){
                        for(int k=1; k<=q; k++){
                            if(j-v +v*k> total/2) break;
                            dp[j-v+v*k]=true;
                        }
                    }
                }
            }
            System.out.println(dp[total/2]?1:0);
        }
    }
}