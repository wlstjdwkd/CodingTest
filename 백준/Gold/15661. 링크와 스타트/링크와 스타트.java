import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    static int N, result;
    static int[][] player;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        player = new int[N][N];
        visit = new boolean[N];
        result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0);
        System.out.println(result);
    }
    private static void solve(int cnt){
        if(cnt == N){
            int start = 0;
            int link = 0;
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    if(visit[i] && visit[j]){
                        start += player[i][j];
                        start += player[j][i];
                    }
                    else if(!visit[i] && !visit[j]){
                        link += player[i][j];
                        link += player[j][i];
                    }
                }
            }

            int diff = Math.abs(start - link);
            result = Math.min(result, diff);

            return;
        }

//        for(int i=idx; i<N; i++){
//            if(!visit[i]){
//                visit[i] = true;
//                solve(i+1, cnt+1);
//                visit[i] = false;
//            }
//        }

        visit[cnt] = true;
        solve(cnt+1);
        visit[cnt] = false;
        solve(cnt+1);
    }
}