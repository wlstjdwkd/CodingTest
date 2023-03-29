import java.util.Scanner;

public class Main {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<a; i++){
            int b = sc.nextInt();
            int c = sc.nextInt();

            sb.append(C(c,b)).append('\n');
        }

        System.out.println(sb);
    }

    static int C(int n, int r){
        if(dp[n][r] > 0){
            return dp[n][r];
        }

        if(n==r || r ==0){
            return dp[n][r] = 1;
        }

        return dp[n][r] = C(n-1, r-1) + C(n-1, r);
    }
}