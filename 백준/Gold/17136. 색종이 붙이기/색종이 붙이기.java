import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int[] paper = {0,5,5,5,5,5};
    public static void main(String[] args) throws IOException {
        arr = new int[10][10];
        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }
    }
    private static void dfs(int x, int y, int cnt){
        if(x>=9 && y>9){ //맨 끝점
            min = Math.min(min,cnt);
            return;
        }
        if(y>9){
            dfs(x+1,0,cnt);
            return;
        }
        if(arr[x][y]==1){
            for(int i=5; i>=1; i--){
                if(paper[i]>0 && square(x,y,i)){
                    attach(x,y,i,0);
                    paper[i]--;
                    dfs(x,y+1, cnt+1);
                    attach(x,y,i,1);
                    paper[i]++;
                }
            }
        }else{
            dfs(x,y+1,cnt);
        }
    }

    private static boolean square(int x, int y, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(i>=10 || j>=10){
                    return false;
                }
                if(arr[i][j]==0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void attach(int x, int y, int size, int state){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                arr[i][j]=state;
            }
        }
    }
}