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

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int t = stoi(st.nextToken());

        Node[] node = new Node[n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int k = stoi(st.nextToken());
            int s = stoi(st.nextToken());
            node[i] = new Node(k, s);
        }

        int[][] dp = new int[n+1][t+1];

        for(int i=1; i<=n; i++){
            for(int j=0; j<=t; j++){
                if(node[i].time <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-node[i].time] + node[i].score);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][t]);

    }

    private static class Node{
        int time;
        int score;

        public Node(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
}