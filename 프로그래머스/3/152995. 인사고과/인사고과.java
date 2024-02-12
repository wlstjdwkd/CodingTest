import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int wanhoScore = scores[0][0] + scores[0][1];
        int[] wanho = {scores[0][0], scores[0][1]};
        Arrays.sort(scores, (a,b) -> a[0]==b[0] ? a[1]-b[1] : -(a[0]-b[0]));
        
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<scores.length; i++){
            if(maxValue < scores[i][1]){
                maxValue = scores[i][1];
            }
            else if(maxValue> scores[i][1]){
                if(scores[i][0] == wanho[0] && scores[i][1] == wanho[1]){
                    return -1;
                }
                continue;
            }
            
            if(scores[i][0] + scores[i][1] > wanhoScore){
                answer++;
            }
        }
        
        
        return answer;
    }
}