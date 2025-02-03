import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K,W,V;
    static int[][] map;
    public static void main(String[] args)throws IOException {
        st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int [N+1][2];
        int[] dp = new int [K+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            map[i][0] = W;
            map[i][1] = V;
        }

        for(int i=1; i<=N; i++){
            for(int j=K; j-map[i][0] >=0; j--){
                dp[j]= Math.max(dp[j],dp[j - map[i][0]] + map[i][1]);
            }
        }
        System.out.println(dp[K]);
    }
}