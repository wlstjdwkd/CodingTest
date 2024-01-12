import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 100,000
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 100,000

        int[][] data = new int[N+1][M+1];
        int[][] acculateSum = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
                acculateSum[i][j] = acculateSum[i][j-1] +acculateSum[i-1][j] - acculateSum[i-1][j-1] + data[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int rowS=1; rowS <=N; rowS++){
            for(int rowE = rowS; rowE <= N; rowE++){
                for(int colS=1; colS <=M; colS++){
                    for(int colE = colS; colE <= M; colE++){
                        int sum = acculateSum[rowE][colE] - acculateSum[rowE][colS-1] - acculateSum[rowS-1][colE] + acculateSum[rowS-1][colS-1];
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}