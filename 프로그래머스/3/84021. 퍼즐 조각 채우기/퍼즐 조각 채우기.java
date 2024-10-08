import java.util.*;

class Solution {
    private class Point implements Comparable<Point>{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point p){
            if(this.x == p.x){
                return this.y - p.y;
            }
            return this.x - p.x;
        }
    }
    private List<List<Point>> t = new ArrayList<>();
    private List<List<Point>> g = new ArrayList<>();
    private final int[] dx = {0,0,1,-1};
    private final int[] dy = {1,-1,0,0};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        int len = game_board.length;
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(game_board[i][j] == 1){
                    game_board[i][j] = 0;
                }
                else{
                    game_board[i][j] = 1;
                }
            }
        }
        
        boolean[][] visited_t = new boolean[len][len];
        boolean[][] visited_g = new boolean[len][len];
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(table[i][j] == 1 && !visited_t[i][j]){
                    bfs(i,j, table, visited_t, t);
                }
                
                if(game_board[i][j] == 1 && !visited_g[i][j]){
                    bfs(i,j,game_board, visited_g, g);
                }
            }
        }
        
        answer = compareBlock(t,g, answer);
        
        return answer;
    }
    
    private int compareBlock(List<List<Point>> table, List<List<Point>> board, int answer){
        int table_size = table.size();
        int board_size = board.size();
        
        boolean[] visited = new boolean[board_size];
        for(int i=0; i<table_size; i++){
            for(int j=0; j<board_size; j++){
                if(!visited[j]){
                    if(table.get(i).size() == board.get(j).size()){
                        if(isRotate(table.get(i), board.get(j))){
                            visited[j]= true;
                            answer += board.get(j).size();
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean isRotate(List<Point> table, List<Point> board){
        Collections.sort(board);
        
        for(int i=0; i<4; i++){
            Collections.sort(table);
            
            int curr_x = table.get(0).x;
            int curr_y = table.get(0).y;
            
            for(int j=0; j<table.size(); j++){
                table.get(j).x -= curr_x;
                table.get(j).y -= curr_y;
            }
            
            boolean check = true;
            for(int j=0; j<board.size(); j++){
                if(board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y){
                    check = false;
                    break;
                }
            }
            
            if(check){
                return true;
            }
            else{
                for(int j=0; j<table.size(); j++){
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }
        
        return false;
    }
    
    private void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> list){
        visited[x][y] = true;
        
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x,y));
        
        List<Point> sub_list = new ArrayList<>();
        sub_list.add(new Point(0,0));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<= nx && nx < board.length && 0<=ny && ny< board.length){
                    if(!visited[nx][ny] && board[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.add(new Point(nx,ny));
                        sub_list.add(new Point(nx-x, ny-y));
                    }
                }
                
            }
        }
        
        list.add(sub_list);
    }
    
}