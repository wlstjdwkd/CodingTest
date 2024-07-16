import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

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
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        map = new int[n+1][n+1];
        pointMap = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            Arrays.fill(map[i], MAX);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                pointMap[i][j] = j;
            }
        }

        int A,B,W;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            A = stoi(st.nextToken());
            B = stoi(st.nextToken());
            W = stoi(st.nextToken());

            map[B][A] = map[A][B] = Math.min(map[A][B],W);
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                        pointMap[i][j] = pointMap[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j){
                    sb.append('-').append(' ');
                    continue;
                }
                sb.append(pointMap[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int n,m;
    private static int[][] map;
    private static int[][] pointMap;

    private static final int MAX = 200 * 10000;



}