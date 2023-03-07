import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M,K;
    static int[][] input;
    static int[] arr;
    static boolean[] visit;
    static int[][] rotation;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotation = new int[K][3];
        arr = new int[K];
        visit = new boolean[K];
        for(int i=0; i<K; i++){
            st= new StringTokenizer(br.readLine());
            rotation[i][0] = Integer.parseInt(st.nextToken());
            rotation[i][1] = Integer.parseInt(st.nextToken());
            rotation[i][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println(min);

    }
    private static void permutation(int cnt){
        if(cnt == K){
            int[][] tmp = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    tmp[i][j] = input[i][j];
                }
            }
            for(int i = 0; i<K; i++) {
                int x1 = rotation[arr[i]][0] - rotation[arr[i]][2] - 1;
                int y1 = rotation[arr[i]][1] - rotation[arr[i]][2] - 1;
                int x2 = rotation[arr[i]][0] + rotation[arr[i]][2] - 1;
                int y2 = rotation[arr[i]][1] + rotation[arr[i]][2] - 1;

                rotate(x1, y1, x2, y2, tmp);
            }
            Min(tmp);
            return;
        }
        for(int i=0; i<K; i++){
            if(!visit[i]){
                visit[i]= true;
                arr[cnt]=i;
                permutation(cnt+1);
                visit[i] = false;
            }
        }
    }
    private static void rotate(int x1, int y1, int x2, int y2, int[][] tmp){
        if(x1 == x2 && y1 == y2){
            return;
        }

        int[] ver = new int[3];
        ver[0] = tmp[x1][y2];
        ver[1] = tmp[x2][y2];
        ver[2] = tmp[x2][y1];

        for(int i = y2; i > y1; i--) {
            tmp[x1][i] = tmp[x1][i - 1];
        }

        for(int i = x2; i > x1; i--) {
            if(i == x1 + 1) tmp[i][y2] = ver[0];
            else tmp[i][y2] = tmp[i - 1][y2];
        }

        for(int i = y1; i < y2; i++) {
            if(i == y2 - 1) tmp[x2][i] = ver[1];
            else tmp[x2][i] = tmp[x2][i + 1];
        }

        for(int i = x1; i < x2; i++) {
            if(i == x2 - 1) tmp[i][y1] = ver[2];
            else tmp[i][y1] = tmp[i + 1][y1];
        }

        rotate(x1 + 1, y1 + 1, x2 - 1, y2 - 1, tmp);
    }
    private static void Min(int[][] tmp){
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = 0; j < M; j++) {
                sum += tmp[i][j];
            }

            min = Math.min(min, sum);
        }
    }
}
