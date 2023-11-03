import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, r1, r2;
    private static ArrayList<Node> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,w));
            list[b].add(new Node(a,w));
        }
        bfs(r1,r2);
    }

    public static void bfs(int a, int b){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(a,0,0));
        boolean[] visited = new boolean[N+1];
        visited[a] = true;
        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.x == b){
                System.out.println(now.w - now.max);
                break;
            }
            for(Node next : list[now.x]){
                if(!visited[next.x]){
                    visited[next.x] = true;
                    q.add(new Node(next.x, now.w + next.w, Math.max(now.max, next.w)));
                }
            }

        }
    }
}
class Node{
    int x, w, max;

    public Node(int x, int w){
        this.x = x;
        this.w = w;
    }
    public Node(int x, int w, int max){
        this.x = x;
        this.w = w;
        this.max = max;
    }
}