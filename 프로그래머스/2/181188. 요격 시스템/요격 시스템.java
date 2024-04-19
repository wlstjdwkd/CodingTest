import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (s1,s2) -> s1[1] - s2[1]);
        
        int before = 0;
        for(int i=0; i<targets.length; i++){
            if(before<=targets[i][0]){
                before = targets[i][1];
                answer++;
            }
        }
        
        
        return answer;
    }
}