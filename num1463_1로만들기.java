import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1463_1로만들기 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a= Integer.parseInt(br.readLine());
        dp = new Integer[a+1];
        dp[0]=dp[1]=0;

        for(int i=2; i<=a; i++){
            dp[i] = dp[i-1]+1;
            if(i%2==0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }
        System.out.println(dp[a]);
    }
//    static int recur(int N){
//        if(dp[N]==null){
////            if(N%6==0){
////                dp[N] = Math.min(recur(N -1), Math.min(recur(N/3), recur(N/2)))+1;
////            }
//            if(N%3==0){
//                dp[N]= Math.min(recur(N-1),recur(N/3))+1;
//            }
//            else if(N%2 ==0){
//                dp[N] = Math.min(recur(N-1),recur(N/2))+1;
//            }
//            else{
//                dp[N]= recur(N-1)+1;
//            }
//        }
//        return dp[N];
//    }
}
