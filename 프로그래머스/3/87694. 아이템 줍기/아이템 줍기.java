import java.util.*;
class Solution {
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        for (int[] r : rectangle)fill(2*r[0],2*r[1],2*r[2],2*r[3]);
        bfs(2*characterX,2*characterY,2*itemX,2*itemY);
        return answer;
        
        
    }
    
    private void fill (int x1, int y1, int x2, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(map[i][j] == 2){
                    continue;
                }
                map[i][j] = 2;
                
                if(i==x1||i==x2||j==y1||j==y2){
                    map[i][j] = 1;
                }
            }
        }
    }
    
    private void bfs(int startX, int startY, int itemX, int itemY){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        int[][] cost = new int[101][101];
        
        cost[startX][startY] = 1;
        while(!q.isEmpty()){
            int[] move = q.poll();
            
            for(int i=0; i<4; i++){
                int moveX = move[0] + dx[i];
                int moveY = move[1] + dy[i];
                
                if(isArea(moveX, moveY)){
                    if(map[moveX][moveY] == 1 && cost[moveX][moveY] == 0){
                        cost[moveX][moveY] = cost[move[0]][move[1]] + 1;
                        q.add(new int[]{moveX, moveY});
                    }
                }
            }
        }
        
        answer = cost[itemX][itemY] / 2;
    }
    
    private boolean isArea(int x, int y){
        return 0<=x && x<=100 && 0<=y && y<=100;
    }
}