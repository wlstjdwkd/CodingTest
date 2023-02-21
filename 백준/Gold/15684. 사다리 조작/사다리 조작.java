import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M,H;
    static int[][] ladder;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = 1;
        }
        for(int i=0;i<=3; i++){
            dfs(1,0,i);
        }
        System.out.println(-1);

    }
    private static void dfs(int nr, int cnt, int size){
        if(cnt == size){
            if(check()){
                System.out.println(size);
                System.exit(0);
            }
            return;
        }
        for(int r = 1; r<=H; r++){
            for(int c=1; c<N; c++){
                if(ladder[r][c]==1){
                    continue;
                }
                if(ladder[r][c-1]==1){
                    continue;
                }
                ladder[r][c]=1;
                dfs(r,cnt+1,size);
                ladder[r][c]=0;
            }
        }
    }
    private static boolean check(){
        for(int i=1; i<=N; i++){
            int location = i;
            int depth = 1;
            while(depth <= H){
                if(ladder[depth][location]==1){
                    location++;
                    depth++;
                }
                else if(ladder[depth][location-1]==1){
                    location--;
                    depth++;
                }
                else{
                    depth++;
                }
            }
            if(i!=location){
                return false;
            }

        }
        return true;
    }
}
