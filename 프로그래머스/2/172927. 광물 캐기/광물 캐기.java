import java.util.*;

class Solution {
    public int[][] section;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int cnt = Math.min(minerals.length/5 + 1, picks[0]+picks[1]+picks[2]);
        section = new int[cnt][3];
        int dp=0, ip=0, sp=0;
        int idx=0;
        
        for(int i=0; i<minerals.length; i+=5){
            if(i/5 == cnt){
                break;
            }
            for(int j=i; j<i+5; j++){
                String m = minerals[j];
                if(m.equals("diamond")){
                    dp++;
                    ip+=5;
                    sp+=25;
                }
                else if(m.equals("iron")){
                    dp += 1;
                    ip += 1;
                    sp += 5;
                }
                else{
                    dp += 1;
                    ip += 1;
                    sp += 1;
                }
                
                if(j==minerals.length-1){
                    break;
                }
            }
            
            section[i/5][0] = dp;
            section[i/5][1] = ip;
            section[i/5][2] = sp;
            
            dp = ip = sp = 0;
        }
        
        Arrays.sort(section, (o1, o2) -> (o2[2]-o1[2]));
        
        for(int i=0; i<cnt; i++){
            if(picks[0]!=0){
                answer += section[i][0]; //다이아로 캤을 때 피로도
                picks[0]--;
            }
            else if(picks[1]!=0){
                answer += section[i][1];
                picks[1]--;
            }
            else if(picks[2]!=0) {
                answer += section[i][2];
                picks[2]--;
            }                
        }
        
        return answer;
    }
}