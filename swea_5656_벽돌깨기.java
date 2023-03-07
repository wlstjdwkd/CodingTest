import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656_벽돌깨기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,W,H;
    static int[][] map;
    static int[] ball;
    static int max;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            ball = new int[N];
            max = Integer.MAX_VALUE;
            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            rePermutation(0);
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    //공 넣는 위치 중복순열
    private static void rePermutation(int cnt){
        if(cnt==N){
            play();
            return;
        }
        for(int i=0; i<W; i++){
            ball[cnt]=i;
            rePermutation(cnt+1);
        }
    }

    private static void play(){
        int[][] temp = new int[H][W];

        for(int i=0; i<H; i++){
            System.arraycopy(map[i],0,temp[i],0,W);
        }

        for(int i=0; i<N; i++){
            int x = -1;
            int y = ball[i];

            for(int j=0; j<H; j++){
                if(temp[j][y] !=0){
                    x=j;
                    break;
                }
            }

            if(x==-1){
                continue;
            }

            breaking(x,y,temp);
            down_brick(temp);

        }
        int cnt=0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(temp[i][j] != 0){
                    cnt++;
                }
            }
        }
        max = Math.min(cnt,max);
    }

    private static void breaking(int x, int y, int[][] tmp){
        int brickNum = tmp[x][y];
        tmp[x][y]=0;
        if(brickNum==1){
            return;
        }
        for( int i=0; i<4; i++){
            int nx = x;
            int ny = y;

            for(int j=0; j<brickNum-1; j++){
                nx += dx[i];
                ny += dy[i];

                if(0> nx || 0 > ny || H <= nx || W <=ny){
                    break;
                }

                if(tmp[nx][ny]==0){
                    continue;
                }
                if(tmp[nx][ny]==1){
                    tmp[nx][ny]=0;
                }
                else{
                    breaking(nx,ny,tmp);
                }
            }
        }

    }

    private static void down_brick(int[][] tmp){
        Queue<Integer> q;
        for (int i = 0; i < W; i++) {
            q = new ArrayDeque<>();
            for (int j = H - 1; j >= 0; j--) {
                if (tmp[j][i] != 0) {
                    q.add(tmp[j][i]);
                    tmp[j][i] = 0;
                }
            }
            int x = H - 1;
            while (!q.isEmpty()) {
                tmp[x--][i] = q.poll();
            }
        }
    }


}