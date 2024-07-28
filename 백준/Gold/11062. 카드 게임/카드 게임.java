import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] cards = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) cards[i] = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n + 2][n + 1];
            // 마지막 카드가 근우의 것인지
            boolean turnK = (n % 2 == 1);

            for (int i = 1; i <= n; i++) {  // i = 선택할 수 있는 카드의 개수
                for (int j = 1; j + i - 1 <= n; j++) {
                    /*
                    left = 시작 인덱스
                    right = 끝 인덱스
                    dp[left][right] = left 번째 카드부터 ~ right 번째 카드까지 남았을 때 근우가 얻는 최대 점수
                    즉 정답은 dp[1][n]을 출력하면 됨.
                     */
                    int left = j;
                    int right = j + i - 1;

                    
                    if (turnK) {
                        dp[left][right] = Math.max(dp[left + 1][right] + cards[left], dp[left][right - 1] + cards[right]);
                    } else {
                        dp[left][right] = Math.min(dp[left + 1][right], dp[left][right - 1]);
                    }
                }
                turnK = !turnK;
            }
            sb.append(dp[1][n]).append('\n');

        }

        System.out.println(sb);
    }

}