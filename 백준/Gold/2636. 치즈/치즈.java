import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M, arr[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int cheese;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    cheese++;
                }
            }
        }
        int cheeseCount=0;
        int time=0;
        while(cheese!=0){
            cheeseCount=cheese;
            time++;
            visited=new boolean[N][M];
            bfs();
        }
        System.out.println(time);
        System.out.println(cheeseCount);

    }
    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    
                    if(arr[nx][ny] == 0) {
                        q.offer(new int[] {nx, ny});
                    } else {
                        cheese--;
                        arr[nx][ny] = 0;
                    }
                }
            }
        }
    }
}