import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17144미세먼지안녕 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R,C,T;
    static int[][] map;
    static int cleaner = -1;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static Queue<Dust> dusts;

    static class Dust{
        int x,y,w;

        public Dust(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(cleaner==-1 && map[i][j]==-1){
                    cleaner =i;
                }
            }
        }

        //시간동안 확산
        for(int i=0; i<T; i++){
            checkDust();

            spread();

            move();
        }

        int res=0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]!=-1){
                    res+= map[i][j];
                }
            }
        }
        System.out.println(res);
    }

    private static void checkDust(){
        dusts = new ArrayDeque<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] ==0|| map[i][j]==-1){
                    continue;
                }
                dusts.add(new Dust(i,j,map[i][j]));
            }
        }
    }

    private static void spread(){
        while(!dusts.isEmpty()){
            Dust now = dusts.poll();

            if(now.w <5){
                continue;
            }
            int amountOfSpread = now.w/5;
            int cnt=0;
            for(int d=0; d<4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];
                if (xx < 0 || xx >= R || yy < 0 || yy >= C) continue;
                // 공기청정기가 있으면
                if (map[xx][yy] == -1) continue;

                if(isInArea(xx,yy)&&!isCleaner(xx,yy)){
                map[xx][yy] += amountOfSpread;
                ++cnt;
            }
            }
                map[now.x][now.y] -= amountOfSpread * cnt;
            }
        }


    private static void move(){
        int top = cleaner;
        int down = cleaner+1;

        //윗부분
        //아래로 내리기
        for(int i= top-1; i>0; i--){
            map[i][0] = map[i-1][0];
        }
        //왼쪽으로
        for(int i=0; i<C-1; i++){
            map[0][i] = map[0][i+1];
        }
        // 위로 당기기
        for (int i = 0; i < top; i++){
            map[i][C - 1] = map[i + 1][C - 1];
        }
        //오른쪽으로
        for(int i=C-1; i>1; i--){
            map[top][i] = map[top][i-1];
        }
        map[top][1]=0;

        // 아래쪽
        // 위로 당기기
        for (int i = down + 1; i < R - 1; i++){
            map[i][0] = map[i + 1][0];
        }
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++){
            map[R - 1][i] = map[R - 1][i + 1];
        }
        // 아래로 당기기
        for (int i = R - 1; i > down; i--){
            map[i][C - 1] = map[i - 1][C - 1];

        }
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--){
            map[down][i] = map[down][i - 1];
        }
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[down][1] = 0;
    }

    private static boolean isInArea(int x, int y){
        return 0<=x && x<R && 0<=y && y<C;
    }

    private static boolean isCleaner(int x, int y){
        return map[x][y]==-1;
    }

}
