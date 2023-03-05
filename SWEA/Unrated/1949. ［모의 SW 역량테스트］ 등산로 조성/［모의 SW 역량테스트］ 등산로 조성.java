import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,K,max,maxNum;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            max=Integer.MIN_VALUE;
            maxNum = Integer.MIN_VALUE;
            map =new int[N][N];
            visit = new boolean[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxNum = Math.max(maxNum,map[i][j]);
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==maxNum){
                        visit[i][j]=true;
                        dfs(i,j,1,true);
                        visit[i][j]=false;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y,int cnt , boolean cut){
        int cur = map[x][y];
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isInArea(nx,ny)&&!visit[nx][ny]){
                if(map[nx][ny]<cur){
                    //경사가 더 낮아야함
                    visit[nx][ny]=true;
                    dfs(nx,ny,cnt+1,cut);
                    visit[nx][ny]= false;
                }
                else if(cut){
                    //경사가 더 낮지 않은데 cut하면 갈수 있는 곳
                    //와 이거 최대 K였음;
                    for(int j=1; j<=K; j++){
                        if(map[nx][ny]-j<cur){
                            map[nx][ny]-=j;
                            dfs(nx,ny,cnt+1,false);
                            map[nx][ny]+=j;
                        }
                    }
                }
            }
        }
        max = Math.max(cnt,max);
    }
    private static boolean isInArea(int x, int y){
        return 0<=x && x<N && 0<=y && y<N;
    }
}