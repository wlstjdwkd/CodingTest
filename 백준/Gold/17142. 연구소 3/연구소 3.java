import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Virus{
        int x;
        int y;
        int time;
        Virus(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Virus> viruses = new ArrayList<>();
    static Virus[] active;
    static int resultMinTime = Integer.MAX_VALUE;
    static int originEmptySpace = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        active = new Virus[M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 0){
                    originEmptySpace++;
                }
                else if(arr[i][j] == 2){
                    viruses.add(new Virus(i, j, 0));
                }
            }
        }

        if(originEmptySpace == 0){
            System.out.println(0);
            return;
        }
        else{
            selectVirus(0, 0);
            System.out.println(resultMinTime == Integer.MAX_VALUE ? -1 : resultMinTime);
        }
    }

    static void selectVirus(int start, int selectCount){
        if(selectCount == M){
            spreadVirus(originEmptySpace);
            return;
        }

        for(int i=start; i<viruses.size(); i++){
            active[selectCount] = viruses.get(i);
            selectVirus(i+1, selectCount+1);
        }
    }

    static void spreadVirus(int emptySpace){
        Queue<Virus> q = new ArrayDeque<>();
        boolean[][] infected = new boolean[N][N];

        for(int i=0; i<M; i++){
            Virus virus = active[i];
            infected[virus.x][virus.y] = true;
            q.offer(virus);
        }

        while(!q.isEmpty()){
            Virus virus = q.poll();

            for(int i=0; i<4; i++){
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(infected[nx][ny] || arr[nx][ny] == 1) continue;

                if(arr[nx][ny] == 0){
                    emptySpace--;
                }

                if(emptySpace == 0){
                    resultMinTime = Math.min(resultMinTime, virus.time+1);
                    return;
                }

                infected[nx][ny] = true;
                q.offer(new Virus(nx, ny, virus.time+1));
            }
        }
    }
}