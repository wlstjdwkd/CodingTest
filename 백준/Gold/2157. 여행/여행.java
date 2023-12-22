import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[M+1][N+1];

        List<Node>[] board = new List[N+1];

        for(int i=0; i<=N; i++){
            board[i] = new ArrayList<>();
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            if(s < e){
                board[s].add(new Node(e, score));
            }
        }

        int result = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        int cnt = 1;
        while(!q.isEmpty() && cnt < M){
            int size = q.size();
            while(size-- > 0){
                int nowIndex = q.poll();
                for(Node nextNode : board[nowIndex]){
                    int nextIndex = nextNode.index;
                    int nextScore = dp[cnt][nowIndex] + nextNode.score;

                    if(dp[cnt+1][nextIndex] < nextScore){
                        dp[cnt+1][nextIndex] = nextScore;
                        q.add(nextIndex);
                    }
                }
            }
            cnt++;
        }

        for(int i=2; i<=M; i++){
            result = Math.max(result, dp[i][N]);
        }
        System.out.println(result);

    }

    private static class Node{
        int index;
        int score;
        public Node(int index, int score){
            this.index = index;
            this.score = score;
        }
    }
}