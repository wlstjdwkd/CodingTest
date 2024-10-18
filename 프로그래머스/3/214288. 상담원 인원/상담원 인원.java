import java.util.*;

class Solution {
    private static int k;
    private static int n;
    private static int[][] reqs;
    private static int[][] wait;
    
    public int solution(int k, int n, int[][] reqs) {
        
        this.k = k;
        this.n = n;
        this.reqs = reqs;
        
        wait = new int[k+1][n-k+2];
        for(int i=1; i<=k; i++){
            getWaitingTime(i);
        }
        
        int answer = getMinTime();
        return answer;
    }
    
    private void getWaitingTime(int index){
        PriorityQueue<Integer> pq;
        int time, next;
        for(int i=1; i<=n-k+1; i++){
            pq = new PriorityQueue<>();
            time = 0;
            for(int j=0; j<reqs.length; j++){
                if(reqs[j][2] == index){
                    if(pq.size() < i){
                        //자리 있으면
                        pq.add(reqs[j][0] + reqs[j][1]);
                    }
                    else{
                        //자리 없으면
                        next = pq.poll();
                        if(next > reqs[j][0]){
                            time += next - reqs[j][0];
                            pq.add(next + reqs[j][1]);
                        }
                        
                        else{
                            pq.add(reqs[j][0] + reqs[j][1]);
                        }
                    }
                }
            }
            
            wait[index][i] = time;
        }
    }
    
    private int getMinTime(){
        int[] num = new int[k+1];
        Arrays.fill(num, 1);
        
        int max, index;
        for(int i=0; i<n-k; i++){
            max = 0;
            index = 0;
            for(int j=1; j<=k; j++){
                if(max < wait[j][num[j]] - wait[j][num[j] + 1]){
                    max = wait[j][num[j]] - wait[j][num[j] + 1];
                    index = j;
                }
            }
            
            num[index]++;
        }
        
        int ret = 0;
        for(int i=1; i<=k; i++){
            ret += wait[i][num[i]];
        }
        
        return ret;
    }
}