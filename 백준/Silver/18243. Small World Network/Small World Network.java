import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static  int INF = Integer.MAX_VALUE/2;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());



        int map[][] = new int[N+1][N+1];
        for (int i = 0; i < N+1 ; i++) {
            Arrays.fill(map[i],INF);
        }
        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }



        for (int i = 1; i < N+1 ; i++) {
            for (int j = 1; j < N+1 ; j++) {
                for (int k = 1; k < N+1 ; k++) {
                    map[j][k] = Math.min(map[j][i]+map[i][k],map[j][k]);
                }
            }
        }

        output(map);
    }

    static void output(int map[][]){
        for (int i = 1; i < N+1 ; i++) {
            for (int j = 1; j < N+1; j++) {
                if((map[i][j] == INF && i != j) || map[i][j] > 6) {
                    System.out.println("Big World!");
                    return;
                }
            }
        }

        System.out.println("Small World!");
    }
}