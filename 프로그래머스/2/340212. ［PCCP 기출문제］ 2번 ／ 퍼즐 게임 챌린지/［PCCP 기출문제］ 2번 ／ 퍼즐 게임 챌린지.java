import java.util.*;

class Solution {
    private static int[] diffss;
    private static int[] timess;
    private static long limits;
    private static int size;
    
    public long solution(int[] diffs, int[] times, long limit) {

        diffss = diffs;
        timess = times;
        limits = limit;
        size = diffs.length;
        
        long end = 1000000000000000L;
        long start = 1;
        while(start<=end){
            long mid = (start + end)/2;
            long result = calculate(mid);
            
            if(result > limit){
                start = mid +1;
            }
            else{
                end = mid-1;
            }
        }
        
        return start;
        
    }
    
    private static long calculate(long level){
        if(level<=0){
            return 1000000000000000L;
        }
        
        long use = 0;
        for(int i=0; i<size; i++){
            if(diffss[i]<=level){
                use += timess[i];
            }
            else{
                long cnt = diffss[i]-level;
                if(i==0){
                    use += (timess[i] * cnt) * timess[i];
                }
                else{
                    use += (timess[i] + timess[i-1]) * cnt + timess[i];
                }
            }
            
            if(use>limits){
                return use;
            }
        }
        
        return use;
    }
}