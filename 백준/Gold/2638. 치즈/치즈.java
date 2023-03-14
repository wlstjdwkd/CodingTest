import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int res;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

    }
    private static void bfs(){
        while(true){
            Queue<int[]> q = new ArrayDeque<>();
            int cheezeCnt=0;
            q.add(new int[] {0,0});
            map[0][0] = -1;
            while(!q.isEmpty()){
                //가에 -1로 변경
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                for(int i=0; i<4; i++){
                    int nx = x+dx[i];
                    int ny = y + dy[i];
                    if(isInArea(nx,ny)){
                        if(map[nx][ny]==0){
                            map[nx][ny]=-1;
                            q.add(new int[]{nx,ny});
                        }
                    }
                }
            }

            Queue<int[]>q2 = new ArrayDeque<>();

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    int cnt=0;
                    if(map[i][j]==1){
                        for(int d=0; d<4; d++){
                            int nx = i+dx[d];
                            int ny = j + dy[d];
                            if(isInArea(nx,ny)){
                                if(map[nx][ny]==-1){
                                    cnt++;
                                    if(cnt>=2)break;
                                }
                            }

                        }
                        if(cnt>=2){
                            q2.add(new int[]{i,j});
                        }
                    }
                }
            }
            res++;
            while(!q2.isEmpty()){
                int[] a = q2.poll();
                map[a[0]][a[1]] = 0;
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==-1){
                        map[i][j]=0;
                    }
                    else if(map[i][j]==1){
                        cheezeCnt++;
                    }
                }
            }
            if(cheezeCnt==0){
                System.out.println(res);
                System.exit(0);
            }

        }
    }
    private static boolean isInArea(int x, int y){
        return 0<=x && x<N && 0<= y && y<M;
    }

}