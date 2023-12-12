class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d_wait = 0;
        int p_wait = 0;
        for(int i = n-1; i>=0; i--){
            d_wait += deliveries[i];
            p_wait += pickups[i];
            
            while(d_wait > 0 || p_wait > 0){
                d_wait -= cap;
                p_wait -= cap;
                
                answer += 2*(i+1);
            }
        }
        
        return answer;
    }
}