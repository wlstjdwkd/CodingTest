import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        int[][] wire = new int[n][2];
        int max = 0;
        StringTokenizer st;
        for(int i = 0; i < wire.length; i++) {
            st = new StringTokenizer(br.readLine()," ");
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        // A전봇대를 기준으로 정렬
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < dp.length; i++) {

            dp[i] = 1;	// 최소 개수인 1로 초기화

            for(int j = 0; j < i; j++) {
                if(wire[i][1] > wire[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(n - max);

    }
}