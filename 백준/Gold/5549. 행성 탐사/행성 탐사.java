import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<n && 0<=y && y<n;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int M = stoi(st.nextToken());
        int N = stoi(st.nextToken());
        int K = stoi(br.readLine());
        int[][][] planets = new int[M+1][N+1][3];
        for(int i=1; i<=M; i++){
            String line = br.readLine();
            for(int j=1; j<=N; j++){
                for(int k=0; k<3; k++){
                    planets[i][j][k] = planets[i][j-1][k] + planets[i-1][j][k] - planets[i-1][j-1][k];
                }
                switch(line.charAt(j-1)){
                    case 'J' :
                        planets[i][j][0]++;
                        break;
                    case 'O':
                        planets[i][j][1]++;
                        break;
                    case 'I':
                        planets[i][j][2]++;
                        break;
                }
            }
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            int d = stoi(st.nextToken());
            for(int j=0; j<3; j++) {
                sb.append(planets[c][d][j] - planets[a - 1][d][j] - planets[c][b - 1][j] + planets[a - 1][b - 1][j]).append(" ");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

}