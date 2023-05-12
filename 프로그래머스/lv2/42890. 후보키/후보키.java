import java.util.*;
class Solution {
    
    Set<String> set = new HashSet<>();
    String[][] g_relation;
    
    public int solution(String[][] relation) {
        g_relation = relation;
        int answer = 0;
        
        for(int i=1; i<= relation[0].length; i++){
            boolean[] selected = new boolean[relation[0].length];
            dfs(0, 0,i,selected);
        }
        
        return set.size();
    }
    
    public void dfs(int idx, int start, int cnt, boolean[] selected){
        if(start == cnt){
            
            String cols="";
            
            for(int i=0; i<selected.length; i++){
                if(selected[i]){
                    cols += i;
                }
            }
            
            if(isPossible(cols, selected)){
                set.add(cols);
            }
            
            return;
        }
        
        
        if(idx>=selected.length){
            return;
        }
        
        selected[idx] = true;
        dfs(idx+1,start+1, cnt, selected);
        
        selected[idx] = false;
        dfs(idx+1, start, cnt, selected);
        
        
    }
    
    public boolean isPossible(String cols, boolean[] selected){
        //최소성
        for(String s : set){
            boolean flag = true;
            for(int i=0; i< s.length(); i++){
                if(!cols.contains(s.charAt(i)+"")){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                return false;
            }
        }
        
        Set<String> values = new HashSet<>();
        int[] col_name = new int[cols.length()];
        int idx = 0;
        for(int i=0; i<selected.length; i++){
            if(selected[i]){
                col_name[idx++] = i;
            }
        }
        
        String value="";
        for(int i=0 ; i< g_relation.length; i++){
            value="";
            for(int j=0; j<col_name.length; j++){
                value += g_relation[i][col_name[j]];
            }
            if(values.contains(value)){
                return false;
            }else{
                values.add(value);
            }
        }
        return true;
    }
}