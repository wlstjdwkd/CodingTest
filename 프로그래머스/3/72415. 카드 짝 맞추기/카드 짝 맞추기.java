import java.util.*;

class Solution {
    Map<Integer, int[][]> card = new HashMap<>();
    int n, result, R, C, order[][], map[][];
    boolean used[];
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    
    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        n=0;
        R=r;
        C=c;
        map = board;
        result = Integer.MAX_VALUE;
        
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] != 0){
                    if(!card.containsKey(board[i][j])){
                        //처음 접근
                        card.put(board[i][j], new int[2][]);
                        card.get(board[i][j])[0] = new int[] {i,j};
                        n++;
                    }
                    else{
                        //짝 찾았음
                        card.get(board[i][j])[1] = new int[] {i,j};
                    }
                }
            }
        }
        
        //배열 순서
        order = new int[2*n][];
        
        //방문 배열
        used = new boolean[n+1];
        
        
        dfs(0);
        
        return result;
    }
    
    //카드 뒤집을 순열 생성
    public void dfs(int cnt){
        if(cnt == n){
            result = Integer.min(result, findCard());
            return;
        }
        
        for(int i=1; i<=n;i++){
            if(!used[i]){
                used[i] = true;
                
                //첫번째 카드 -> 두번째 카드
                order[cnt*2] = card.get(i)[0];
                order[cnt*2+1] = card.get(i)[1];
                dfs(cnt+1);
                
                //두번째 카드 -> 첫번째 카드
                order[cnt*2] = card.get(i)[1];
                order[cnt*2+1] = card.get(i)[0];
                dfs(cnt+1);
                
                used[i] = false;
            }
        }
    }
    
    //order대로 뒤집어가며 BFS로 비용 계산
    public int findCard(){
        int[][] copy = new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                copy[i][j] = map[i][j];
            }
        }
        
        int[] start = {R,C,0};
        int cost = 0;
        
        for(int[] next : order){
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[4][4];
            q.offer(start);
            visited[start[0]][start[1]] = true;
            
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int w = cur[2];
                
                //도착
                if(r == next[0] && c == next[1]){
                    cost += w+1;
                    copy[next[0]][next[1]] = 0;
                    break;
                }
                
                //일반 커서 옮기기
                for(int d=0; d<4; d++){
                    int nr = r+dr[d];
                    int nc = c+dc[d];
                    
                    if(0<=nr &&nr <4 && 0<=nc &&nc<4){
                        if(!visited[nr][nc]){
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr,nc,w+1});
                        }
                    }
                }
                
                //ctrl 커서
                for(int d=0; d<4; d++){
                    int nr = r;
                    int nc = c;
                    
                    while(true){
                        if(nr+dr[d]<0 || nc+dc[d]<0 ||nr+dr[d] == 4 || nc+dc[d] == 4){
                            if(!visited[nr][nc]){
                                visited[nr][nc] = true;
                                q.offer(new int[]{nr, nc, w+1});
                                
                            }
                            break;
                        }
                        nr+=dr[d];
                        nc+=dc[d];
                        
                        //제일 가까운 카드 만나면 해당 좌표로 이동
                        if(copy[nr][nc]!=0){
                            if(!visited[nr][nc]){
                                visited[nr][nc] = true;
                                q.offer(new int[]{nr, nc, w+1});
                            }
                            break;
                        }
                    }
                }
            }
            
            //현재 좌표로 이동
            start[0] = next[0];
            start[1] = next[1];
            start[2] = 0;
        }
        return cost;
    }
}