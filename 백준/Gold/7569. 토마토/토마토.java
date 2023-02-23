import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] board;
    static int M,N,H;
    static int[] dx ={-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<Tomato> q =new ArrayDeque<>();
    static class Tomato{
        int x;
        int y;
        int z;

        public Tomato(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M =Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][N][M];
        for(int i=0; i<H;i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if(board[i][j][k]==1){
                        q.add(new Tomato(i,j,k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }
    private static int bfs(){
        while(!q.isEmpty()){
            Tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            int z = t.z;
            for(int i=0; i<6; i++){
                int nx = x+dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if(nx>=0 && ny >=0 && nz >= 0 && nx< N && ny < M && nz < H){
                    if(board[nz][nx][ny]==0){
                        q.add(new Tomato(nz,nx, ny));
                        board[nz][nx][ny] = board[z][x][y]+1;
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<H;i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(board[i][j][k]==0){
                        return -1;
                    }
                    result=Math.max(result,board[i][j][k]);
                }
            }
        }

        return result-1;

    }
}