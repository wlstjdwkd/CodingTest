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
//        return 0<= x && x<R && 0<=y && y<C;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        visit = new boolean[N][M];
        dfs(0,0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int start){
        answer += check(depth) ? 1 : 0;

        if(depth == N*M){
            return;
        }

        for(int i=start; i<N*M; i++){
            int r = i/M;
            int c = i%M;
            if(!visit[r][c]){
                visit[r][c] = true;
                dfs(depth+1, i+1);
                visit[r][c] = false;
            }
        }
    }

    private static boolean check(int depth){
        if(depth<4){
            return true;
        }
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M-1; j++){
                if(visit[i][j] && visit[i+1][j] && visit[i][j+1] && visit[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }

    private static int N,M;
    private static boolean[][] visit;
    private static int answer;


}