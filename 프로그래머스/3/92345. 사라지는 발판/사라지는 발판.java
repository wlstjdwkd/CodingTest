import java.util.*;

class Solution {
    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};
    private static int N,M;
    private static int MAX = 987654321;
    
    private static class Turn{
        boolean isWin;
        int cnt;
        
        Turn(boolean isWin, int cnt){
            this.isWin = isWin;
            this.cnt = cnt;
        }
    }
    
    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        
        N = board.length;
        M= board[0].length;
        
        Turn res = dfs(board, aloc, bloc, true, 0);
        
        return res.cnt;
    }
    
    private static Turn dfs(int[][] board, int[] aloc, int[] bloc, boolean isATurn, int cnt){
        int ay = aloc[0];
        int ax = aloc[1];
        int by = bloc[0];
        int bx = bloc[1];
        
        if((board[ay][ax] == 0 && isATurn) || (board[by][bx] == 0 && !isATurn)){
            return new Turn(false, cnt);
        }
        
        int win = MAX;
        int lose = 0;
        int y,x;
        
        if(isATurn){
            y = ay;
            x = ax;
        }
        else{
            y = by;
            x = bx;
        }
        
        board[y][x] = 0;
        
        Turn res = null;
        boolean canGo = false;
        for(int d=0; d<4; d++){
            int nx = x+dx[d];
            int ny = y + dy[d];
            if(0<=nx && nx <M && 0<= ny && ny <N){
                if(board[ny][nx] == 1){
                    canGo = true;
                    if(isATurn){
                        res = dfs(board, new int[]{ny,nx}, bloc, !isATurn, cnt+1);
                    }
                    else{
                        res = dfs(board, aloc, new int[]{ny,nx}, !isATurn, cnt+1);
                    }

                    if(res.isWin){
                        lose = Math.max(lose,res.cnt);
                    }
                    else{
                        win = Math.min(win, res.cnt);
                    }
                }
                
            }
            
        }
        board[y][x] = 1;
        
        if(!canGo){
            return new Turn(false, cnt);
        }
        else if(win!=MAX){
            return new Turn(true, win);
        }
        else{
            return new Turn(false, lose);
        }
    }
}