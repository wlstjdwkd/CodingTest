import java.util.*;

class Solution {
    static class Point{
        int num, c;
        Point(int num, int c){
            this.num = num;
            this.c = c;
        }
    }
    Point[] dp;
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        dp = new Point[e+1];
        
        for(int i=0; i<=e; i++){
            dp[i] = new Point(i,0);
        }
        
        for(int i=1; i<=e; i++){
            for(int j=i; j<=e; j+=i){
                dp[j].c++;
            }
        }
        
        Arrays.sort(dp, (o1, o2) -> o1.c == o2.c ? o1.num - o2.num : o2.c - o1.c);

        for(int i=0; i<starts.length; i++){
            for(int j=0; j<=e; j++){
                if(starts[i] <= dp[j].num){
                    answer[i] = dp[j].num;
                    break;
                }
            }
        }
        
        return answer;
    }
}