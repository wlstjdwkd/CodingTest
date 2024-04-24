import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열 크기에 대한 입력
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        
		// 2차원 배열 및 dp 초기화
        int[][] arr = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
		
        // 2차원 배열의 값을 읽고, dp 배열 누적 합계 계산
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }
		
        // K : 합을 구할 부분의 개수 입력 받기
        int K = Integer.parseInt(br.readLine());
        // 하위 배열 경계(i, j, x, y)를 읽고 dp 배열을 사용하여 합계를 계산하고 결과 출력
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1];
            System.out.println(sum);
        }
    }
}