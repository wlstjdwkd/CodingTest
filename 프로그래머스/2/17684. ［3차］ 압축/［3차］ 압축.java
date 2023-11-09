import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] result = {};
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int count = 1;
        for(int i= 65; i<=90; i++){
            map.put(Character.toString((char)i), count++);
        }
        int start=0;
        while(start<msg.length()){
            int end = start;
            while(end + 1 <= msg.length() && map.containsKey(msg.substring(start, end+1))){
                end++;
            }
            
            answer.add(map.get(msg.substring(start,end)));
            if(end < msg.length()){
                map.put(msg.substring(start, end + 1), count++);
            }
            
            start = end;
        }
        result = new int[answer.size()];
        
        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}