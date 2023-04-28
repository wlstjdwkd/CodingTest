import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int cnt=0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1=0,sum2=0;
        for(int i=0; i<queue1.length; i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        for(int i=0; i<queue1.length*3; i++){
            
            if(sum1>sum2){
                int temp= q1.poll();
                sum1-=temp;
                sum2+=temp;
                q2.add(temp);
                cnt++;
            }
            else if(sum1<sum2){
                int temp= q2.poll();
                sum1+=temp;
                sum2-=temp;
                q1.add(temp);
                cnt++;
            }
            else if(sum1==sum2){
                return cnt;
            }
        }
        return answer;
    }
}