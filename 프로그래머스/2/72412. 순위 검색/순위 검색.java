import java.util.*;
class Solution {
    private Map<String, List<Integer>> map = new HashMap<>();
    private boolean selidx[] = new boolean[4];
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(String i : info){
            String[] iSplit = i.split(" ");
            comb(iSplit,0);
        }
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        for(int i=0; i<query.length; i++){
            String q = query[i];
            q = q.replace(" and","");
            String[] qSplit = q.split(" ");
            String key = "";
            for(int j=0; j<4; j++){
                key+=qSplit[j].equals("-") ? "" : qSplit[j];
            }
            int score = Integer.parseInt(qSplit[4]);
            List<Integer> scoreList = map.getOrDefault(key, new ArrayList<Integer>());
            int s = 0;
            int l = scoreList.size();
            while(s < l){
                int mid = (s + l) / 2;
                if(scoreList.get(mid) < score){
                    s = mid + 1;
                }
                else{
                    l = mid;
                }
            }
            answer[i] = scoreList.size()-s;
        }
        
        return answer;
    }
    private void comb(String[] iSplit, int idx){
        if(idx == 4){
            String s = "";
            for(int i=0; i<4; i++){
                s += selidx[i] ? iSplit[i] : "";
            }
            map.put(s, map.getOrDefault(s, new ArrayList<Integer>()));
            map.get(s).add(Integer.parseInt(iSplit[4]));
            return;
        }
        selidx[idx] = true;
        comb(iSplit, idx + 1);
        selidx[idx] = false;
        comb(iSplit, idx + 1);
    }
    
}