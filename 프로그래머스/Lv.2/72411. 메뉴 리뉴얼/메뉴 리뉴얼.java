import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, Integer> h = new HashMap<>();
    static ArrayList<String> answer = new ArrayList<>();
    
    public ArrayList<String> solution(String[] orders, int[] course) {
        
        for(int i=0; i< orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for(int c : course){
            for(String order : orders){
                combi("", order, c);
            }
            
            if(!h.isEmpty()){
                List<Integer> cList = new ArrayList<>(h.values());
                int max = Collections.max(cList);
                
                if(max>1){
                    for(String menu : h.keySet()){
                        if(h.get(menu) == max){
                            answer.add(menu);
                        }
                    }
                }
                h.clear();
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
    
    public static void combi(String menu, String order, int c){
        if(c==0){
            h.put(menu,h.getOrDefault(menu,0) +1);
            return;
        }
        
        for(int i=0; i<order.length(); i++){
            combi(menu + order.charAt(i), order.substring(i+1), c-1);
        }
    }
}