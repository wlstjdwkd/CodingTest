import java.util.*;
class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        
        long left = 1;
        long right = (long)(Math.pow(10,9)*Math.pow(10,5)*4);
        
        int len = g.length;
        
        while(left<=right){
            long mid = (left+right)/2;
            
            int gold = 0, silver = 0, sum = 0;
            for(int i=0; i<len; i++){
                int weight = w[i];
                int time = t[i];
                
                //몇 번 왕복 운반 가능한지
                long cnt = mid/(time*2);
                if((mid % (time * 2)) >= time){
                    //추가로 편도 운반 가능한지
                    cnt++;
                }
                
                gold += Math.min(g[i], weight * cnt);
                silver += Math.min(s[i], weight * cnt);
                sum += Math.min(g[i]+s[i], weight * cnt);
            }
            
            if(gold>=a && silver >= b && sum >= a+b){
                answer = mid;
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}