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
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        invest = new int[n+1][m+1];
        info = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        path = new int[n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int j=1; j<=m; j++){
                int benefit = stoi(st.nextToken());
                info[i][j] = benefit;
            }
        }

        findMaxBenefit();
        getPath(n,m);

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n][m]).append("\n");

        for(int i=1; i<=m; i++){
            sb.append(path[i]).append(" ");
        }

        System.out.println(sb);

    }

    private static void findMaxBenefit() {
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                for(int k=n-j; k>=0; k--){
                    if(dp[k][i-1] + info[j][i] > dp[j+k][i]){
                        dp[j+k][i] = dp[k][i-1] + info[j][i];
                        invest[j+k][i] = j;
                    }
                }
            }
        }
    }

    private static void getPath(int n, int m){
        if(m == 0){
            return;
        }

        path[m] = invest[n][m];
        getPath(n-path[m], m-1);

    }

    static int n,m;
    static int[][] dp, info, invest;
    static int[] path;


}