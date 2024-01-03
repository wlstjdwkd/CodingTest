import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 학생 수
        int M = Integer.parseInt(st.nextToken());   // 블록의 최대 개수
        int H = Integer.parseInt(st.nextToken());   // 맞춰야 하는 높이

        int[][] dp = new int[N+1][H+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<=N; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=H; j++){
                for(int x : list[i]){
                    if(j-x >= 0){
                        //블록을 쌓을 수 있는 경우 더해줌
                        dp[i][j] += dp[i-1][j-x];
                        dp[i][j] %= 10007;
                    }
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }
        System.out.println(dp[N][H] % 10007);
    }
}