import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        
        String[] result = new String[len];
        for(int i=0 ; i<len; i++){
            result[i] = numbers[i] +"";
        }
        
        Comparator<String> com = (s1,s2) -> (s2+s1).compareTo(s1+s2);
        
        Arrays.sort(result, com);
        
        for(String s : result){
            answer += s;
        }
        
        if(answer.charAt(0)=='0'){
            return "0";
        }
        
        return answer;
    }
}