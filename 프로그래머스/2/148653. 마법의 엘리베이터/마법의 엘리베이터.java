import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String s = String.valueOf(storey);
        
        int[] num = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            num[i] = s.charAt(i)- '0';
        }
        
        for(int i=s.length()-1; i>=0; i--){
            int idx = num[i];
            
            if(idx<=4){
                answer += idx;
            }
            else if(idx>=6){
                idx = 10-idx;
                answer += idx;
                if(i>0){
                    num[i-1]++;
                }
                else{
                    answer++;
                    break;
                }
            }
            else{
                //5인경우
                if(i>0){
                    if(num[i-1] >= 5){
                        answer +=5;
                        num[i-1]++;
                    }
                    else{
                        answer+=5;
                    }
                }
                else{
                    answer+=5;
                    break;
                }
            }
        }
        
        return answer;
    }
}