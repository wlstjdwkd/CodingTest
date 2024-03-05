import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(k>=enemy.length){
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<enemy.length; i++){
            pq.add(enemy[i]);
            n-= enemy[i];
            if(n<0){
                if(k>0){
                    n+= pq.poll();
                    k--;
                    pq.add(0);
                }
                else{
                    return pq.size()-1;
                }
            }
        }
        
        
        return pq.size();
    }
}