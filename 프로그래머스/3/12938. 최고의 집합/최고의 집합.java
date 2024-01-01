class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        int Q =s /n;
        int R = s % n;
        if(Q == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else{
            answer = new int[n];
        }
        
        for(int i=0; i<n; i++){
            if(R > 0){
                if(i < n-R){
                    answer[i] = Q;
                }
                else{
                    answer[i] = Q +1;
                }
            }
            else{
                answer[i] = Q;
            }
        }
        
        return answer;
    }
}