import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int MOD = 1234567891;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);// 10
            int r = Integer.parseInt(line[1]);// 2

            long[] facto = new long[n + 1];//1! ~ 10!
            facto[1] = 1; //1! = 1
            for (int i = 2; i <= n; i++) {
                facto[i] = (facto[i - 1] * i) % MOD;
            }

            long bottom = (facto[r] * facto[n-r]) % MOD;
            bottom = pow(bottom, MOD -2);

            System.out.println("#" + tc + " " + (facto[n] * bottom) % MOD );
        }
    }

    private static long pow(long a, int b) {
        if(b == 0)
            return 1;

        else if(b == 1)
            return a;

        if(b % 2 == 0) {
            long tmp = pow(a, b/2);
            return (tmp * tmp) % MOD;
        }

        long tmp = pow(a, b-1) % MOD;
        return (tmp * a) % MOD;
    }

//    private static int combi(int N,int R){
//        if(R==0 || N==R){
//            return 1;
//        }
//        else{
//            return combi(N-1,R-1)%1234567891+combi(N-1,R)%1234567891;
//        }
//    }
}