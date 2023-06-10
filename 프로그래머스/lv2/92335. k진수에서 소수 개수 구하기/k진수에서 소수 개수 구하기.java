import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = String.valueOf(Integer.toString(n,k));
        
        StringTokenizer st = new StringTokenizer(num, "0");
        while(st.hasMoreTokens()){
            long num1 = Long.parseLong(st.nextToken());
            if(num1>1){
                if(isPrime(num1)==1){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    public int isPrime(long n) {
        for (int i = 2; i<=(long)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return 0;
          }
        }
        return 1;
    }
}