import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static double[] percent = new double[4];

    private static boolean[][] visited = new boolean[30][30];

    private static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<4; i++){
            percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        result = 0;
        dfs(15,15,0,n,1);
        System.out.println(result);

    }

    private static void dfs(int x, int y, int idx, int n, double total){
        if(idx==n){
            result+=total;
            return;
        }

        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx <30 && 0<=ny && ny <30){
                if(visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    dfs(nx,ny, idx+1,n,total*percent[i]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}