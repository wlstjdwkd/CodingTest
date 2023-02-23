import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R,C;
    static int[][] arr;
    static boolean[] visit = new boolean[26];
    static int[] dx={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int ans;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j)-'A';
            }
        }
        dfs(0,0,0);
        System.out.println(ans);
    }
    private static void dfs(int r, int c, int cnt){
        if(visit[arr[r][c]]){
            ans = Math.max(ans, cnt);
        }
        else{
            visit[arr[r][c]]=true;
            for(int i= 0; i<4; i++){
                int nx = r+dx[i];
                int ny = c + dy[i];
                if(nx>=0&&nx<R && ny>=0 && ny<C){
                    dfs(nx,ny,cnt+1);
                }
            }
            visit[arr[r][c]]=false;
        }
    }
}