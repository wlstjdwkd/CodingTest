import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num14500테트로미노 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] map;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visit[i][j] = true;
                dfs(i,j,map[i][j],1);
                visit[i][j] = false;
            }
        }
        System.out.println(max);

    }
    private static void dfs(int row, int col, int sum, int count){
        if(count ==4){
            max = Math.max(sum,max);
            return;
        }

        for(int i=0; i<4; i++){
            int nr = row + dx[i];
            int nc = col + dy[i];

            if(isInArea(nr,nc)){
                if(!visit[nr][nc]){
                    if(count == 2) {
                        visit[nr][nc] = true;
                        dfs(row, col, sum + map[nr][nc], count + 1);
                        visit[nr][nc] = false;
                    }

                    visit[nr][nc] = true;
                    dfs(nr, nc, sum + map[nr][nc], count + 1);
                    visit[nr][nc] = false;
                }
            }
        }
    }
    private static boolean isInArea(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
}
