import java.io.*;
import java.util.*;
import java.awt.Point;

class Solution {
    static char arr[][];
    static int mm,nn;
    static Queue<Point> qu = new ArrayDeque<>();
    
    public static void square(int x, int y, char c){
        int dx[] = {0,1,1};
        int dy[] = {1,0,1};
        
        Queue<Point> temp = new ArrayDeque<>();
        for(int i=0; i<3; i++){
            int nx = x+dx[i];
            int ny = y + dy[i];
            if(0<= nx && nx < mm && 0<= ny && ny <nn && arr[nx][ny] == c){
                temp.add(new Point(nx,ny));
            }
        }
        
        if(temp.size() == 3){
            qu.add(new Point(x,y));
            for(int i=0; i<3; i++){
                qu.add(temp.poll());
            }
        }
    }
    
    public static void down(){
        for(int k=0; k<mm; k++){
            for(int i=mm-1; i>0; i--){
                for(int j=0; j<nn; j++){
                    if(arr[i][j] == '0' && arr[i-1][j] != '0'){
                        arr[i][j] = arr[i-1][j];
                        arr[i-1][j] = '0';
                    }
                }
            }
        }
    }
    
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new char[m][n];
        mm=m;
        nn=n;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
        
        int cnt=0;
        while(cnt<1000){
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j]!= '0'){
                        square(i,j, arr[i][j]);
                    }
                }
            }
            
            while(!qu.isEmpty()){
                Point p = qu.poll();
                if(arr[p.x][p.y] != '0'){
                    arr[p.x][p.y] = '0';
                    answer++;
                }
                else{
                    continue;
                }
            }
            
            down();
            cnt++;
            
        }
        
        
        return answer;
    }
}