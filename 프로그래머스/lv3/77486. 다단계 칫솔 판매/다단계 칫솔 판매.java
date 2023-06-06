import java.util.*;
 
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int[] result = new int[enroll.length];
        //자신, 부모
        HashMap<String, String> map = new HashMap<>();
        //자신, 자신 순서
        HashMap<String, Integer> mapSeq = new HashMap<>();
        
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i],referral[i]);
            mapSeq.put(enroll[i],i);
        }
        
        for(int i = 0; i < seller.length; i++) {
            int cost = amount[i] * 100;
            String currentSeller = seller[i];
            
            while(!currentSeller.equals("-")) {
                
                
                
                int idx = mapSeq.get(currentSeller);
                
                // for(int j = 0; j < enroll.length; j++) {
                //     if(currentSeller.equals(enroll[j])) {
                //         idx = j;
                //         break;
                //     }
                // }
                
                String parent = referral[idx];
                int tenPercent = cost/10;
                int sellerCost = cost - tenPercent;
                
                result[idx] += sellerCost;
                
                currentSeller = parent;
                cost = tenPercent;
                if(tenPercent==0){
                    break;
                }
            }
            
        }
        return result;
    }
}
