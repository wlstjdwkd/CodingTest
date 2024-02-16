import java.util.*;

class Solution {
    public List<List<Integer>> map = new ArrayList<>();
    public int N, answer;
    public int dfs(int cur, int before){
        //리프 노드
        if(map.get(cur).size() == 1 && map.get(cur).get(0) == before){
            return 1;
        }
        
        //리프 노드 x
        int tmpRes = 0;
        for(int i=0; i<map.get(cur).size(); i++){
            int next = map.get(cur).get(i);
            if(next == before) continue;
            tmpRes += dfs(next, cur);
        }
        
        if(tmpRes == 0){
            return 1;
        }
        
        answer++;
        return 0;
    }
    public int solution(int n, int[][] lighthouse) {
        
        N= n;
        for(int i=0; i<=n; i++){
            map.add(new ArrayList<>());
        }
        for(int i=0; i<lighthouse.length; i++){
            map.get(lighthouse[i][0]).add(lighthouse[i][1]);
            map.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        dfs(1,0);
        return answer;
    }
}