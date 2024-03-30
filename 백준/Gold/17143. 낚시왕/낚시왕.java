import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int R, C, M;
    static Shark[][] map;
    static int answer=0;
    static int dx[] = {-1, 1,0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r, c, s, d, z);
        }

        for(int col =0; col<C; col++){
            //1. 낚시왕이 상어를 잡는다.
            for(int row =0; row<R; row++){
                if(map[row][col]!=null){
                    answer += map[row][col].z;
                    map[row][col] = null;
                    break;
                }
            }

            //2. 상어가 이동한다.
            Queue<Shark> q = new ArrayDeque<>();
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]!=null){
                        q.add(map[i][j]);
                        map[i][j] = null;
                    }
                }
            }

            map = new Shark[R][C];
            while(!q.isEmpty()){
                Shark sm = q.poll();
                int speed = sm.s;
                if(sm.d == 0 || sm.d == 1){
                    speed %= (2*R-2);
                }
                else{
                    speed %= (2*C-2);
                }

                for(int s = 0; s<speed; s++){
                    int newR = sm.r + dx[sm.d];
                    int newC = sm.c + dy[sm.d];

                    if(newR<0 || newR>=R || newC<0 || newC>=C){
                        sm.r -= dx[sm.d];
                        sm.c -= dy[sm.d];
                        if(sm.d == 0){
                            sm.d = 1;
                        }
                        else if(sm.d == 1){
                            sm.d = 0;
                        }
                        else if(sm.d == 2){
                            sm.d = 3;
                        }
                        else if(sm.d == 3){
                            sm.d = 2;
                        }

                        continue;
                    }

                    sm.r = newR;
                    sm.c = newC;
                }

                //상어가 이동한 위치에 상어가 있을 경우 크기가 큰 상어가 살아남는다.
                if(map[sm.r][sm.c] == null){
                    map[sm.r][sm.c] = sm;
                }
                else{
                    if(map[sm.r][sm.c].z < sm.z){
                        map[sm.r][sm.c] = sm;
                    }
                }
            }

        }
        System.out.println(answer);
    }

    static class Shark{
        int r, c, s, d, z;
        Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}