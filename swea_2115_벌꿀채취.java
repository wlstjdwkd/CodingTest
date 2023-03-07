import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2115_벌꿀채취 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int max;
    static int N,M,C;
    static int[][] map;
    static int[][] honey;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            honey = new int[N][N];

            max = Integer.MIN_VALUE;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            play();


            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void play(){
        profit();
        for(int i=0; i<N;i++){
            for(int j=0; j<=N-M; j++){
                combi(i,j+M,1,honey[i][j]);
            }
        }
    }

    private static void combi(int x, int y, int cnt, int sum){
        if(cnt ==2){
            max = Math.max(sum,max);
            return;
        }
        for(int i=x; i<N; i++){
            for(int j=y; j<=N-M; j++){
                combi(i,j,cnt+1,sum+honey[i][j]);
            }
            y=0;
        }
    }
    private static void profit(){
        for(int i=0; i<N; i++){
            for(int j=0; j<=N-M; j++){
                subset(i, j,0,0,0);
            }
        }
    }
    private static void subset(int x, int y, int cnt, int sum, int totalSum){
        if(sum>C){
            return;
        }

        if(cnt==M){
            honey[x][y-M] = Math.max(totalSum,honey[x][y-M]);
            return;
        }
        subset(x, y+1,cnt+1,sum+map[x][y],totalSum+map[x][y]*map[x][y]);

        subset(x, y+1, cnt+1, sum, totalSum);
    }
}
