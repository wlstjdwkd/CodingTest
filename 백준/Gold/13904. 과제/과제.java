import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new int[]{d, w});
        }

        Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);

        int[] dp = new int[10001];

        for(int[] p : list){
            for(int i=p[0]; i>0; i--){
                if(dp[i] == 0){
                    dp[i] = p[1];
                    break;
                }
            }
        }

        int total = 0;
        for(int num : dp){
            total += num;
        }

        System.out.println(total);
    }
}