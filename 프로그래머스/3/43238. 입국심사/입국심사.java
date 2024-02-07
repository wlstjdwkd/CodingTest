import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        long minTime = 1;
        long maxTime = (long) times[times.length-1] * n;
        long time = 0;
        while(minTime <= maxTime){
            long midTime = (minTime + maxTime) / 2;
            
            long peopleCount = 0;
            for(int t : times){
                peopleCount += midTime / t;
            }
            
            if(peopleCount < n){
                minTime = midTime +1;
            }
            
            else{
                time = midTime;
                maxTime = midTime - 1;
            }
            
        }
        
        
        return time;
    }
}