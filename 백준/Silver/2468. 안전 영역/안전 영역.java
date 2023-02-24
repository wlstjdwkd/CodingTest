import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int result=1;
    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int maxHeight;
    static boolean[][] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        maxHeight=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]>maxHeight){
                    maxHeight=arr[i][j];
                }
            }
        }
        int max=0;
        for(int h=0; h<maxHeight; h++){
            visit= new boolean[N][N];
            int cnt=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j] && arr[i][j]>h){
                        cnt+=bfs(i,j,h);
                    }
                }
            }
            if(cnt>max){
                max=cnt;
            }
        }
        System.out.println(max);

    }
    private static int bfs(int x, int y, int height){
        Queue<int[]>q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];
            for(int i=0; i<4; i++){
                int nx = px+dx[i];
                int ny = py + dy[i];
                if(nx>=0 && nx<N && ny>=0 &&ny<N){
                    if(!visit[nx][ny]&& arr[nx][ny]>height){
                        visit[nx][ny]= true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return 1;
    }
}