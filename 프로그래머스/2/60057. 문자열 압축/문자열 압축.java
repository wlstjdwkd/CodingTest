import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<= s.length()/2; i++){
            String a = compress(s,i);
            
            answer = Math.min(answer, a.length());
        }
        return answer;
    }
    private String compress(String s, int num){
        int count = 1;
        String pattern = s.substring(0,num);
        
        StringBuilder builder = new StringBuilder();
        for(int i=num; i<s.length(); i+=num){
            if(i+num > s.length()){
                //압축이 불가능
                builder.append(s.substring(i));
            }
            else{
                String target = s.substring(i,i+num);
                
                if(target.equals(pattern)){
                    //패턴과 동일
                    count++;
                }
                
                else{
                    //패턴과 다르면
                    if(count > 1){
                        //2회이상 압축이 가능할 경우
                        builder.append(count);
                        count=1;
                    }
                    builder.append(pattern);
                    
                    pattern = target;
                }
            }
        }
        if(count > 1){
            builder.append(count);
        }
        builder.append(pattern);
        
        return builder.toString();
    }
}