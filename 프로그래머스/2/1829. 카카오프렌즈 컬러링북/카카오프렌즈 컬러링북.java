import java.util.*;

class Solution {
    private static final int[] DX = {0,0,-1,1};
    private static final int[] DY = {-1,1,0,0};
    private boolean[][] isVisit;
    
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        
        int[][] copy = picture.clone();
        
        isVisit = new boolean[m][n];
        for(int i=0; i<copy.length; i++){
            for(int j=0; j<copy[i].length; j++){
                if(copy[i][j] > 0 && !isVisit[i][j]){
                    answer[0]++;
                    answer[1] = Math.max(answer[1], bfs(m,n,i,j, copy));
                }
            }
        }
        
        return answer;
    }
    
    private int bfs(int m, int n, int x, int y, int[][] picture){
        int size = 1;
        isVisit[x][y] = true;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] position = q.poll();
            for(int i=0; i<4; i++){
                int dx = position[0] + DX[i];
                int dy = position[1] + DY[i];
                
                if(dx>-1 && dx<m &&dy>-1 && dy<n && picture[dx][dy] == picture[x][y] && !isVisit[dx][dy]){
                    q.add(new int[]{dx,dy});
                    
                    isVisit[dx][dy] = true;
                    
                    size++;
                }
                
            }
        }
        
        return size;
    }
    
}