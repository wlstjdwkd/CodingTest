import java.util.*;

class Solution {
    int[][] fragments;
    int fragmentIdx = 1;
    Map<Integer, Integer> fragmentsInfo = new HashMap<>();
    boolean[][] visited;
    int rSize, cSize;
    int[] dirR = {-1,1,0,0};
    int[] dirC = {0,0,-1,1};
    
    public int solution(int[][] land) {
        int answer = 0;
        rSize = land.length;
        cSize = land[0].length;
        fragments = new int[rSize][cSize];
        visited = new boolean[rSize][cSize];
        
        for(int r=0; r<rSize; r++){
            for(int c=0; c<cSize; c++){
                if(visited[r][c] || land[r][c] == 0){
                    continue;
                }
                
                initFragment(land, r, c);
            }
        }
        
        for(int c=0; c<cSize; c++){
            Set<Integer> fragmentTypes = new HashSet<>();
            int tmpMaxAmount = 0;
            for(int r = 0; r<rSize; r++){
                if(fragments[r][c] > 0){
                    fragmentTypes.add(fragments[r][c]);
                }
            }
            
            for(int frg : fragmentTypes){
                tmpMaxAmount += fragmentsInfo.get(frg);
            }
            
            answer = Math.max(answer, tmpMaxAmount);
        }
        
        return answer;
    }
    
    public void initFragment(int[][] land, int r, int c){
        visited[r][c] = true;
        fragments[r][c] = fragmentIdx;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        int size = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            size++;
            
            for(int d=0; d<4; d++){
                int nxtR = cur[0] + dirR[d];
                int nxtC = cur[1] + dirC[d];
                
                if(nxtR<0 || nxtR >= rSize || nxtC < 0 || nxtC >= cSize || visited[nxtR][nxtC] || land[nxtR][nxtC] == 0){
                    continue;
                }
                
                visited[nxtR][nxtC] = true;
                fragments[nxtR][nxtC] = fragmentIdx;
                q.add(new int[]{nxtR, nxtC});
            }
        }
        
        fragmentsInfo.put(fragmentIdx++, size);
    }
}