import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int n;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        String line = null;
        while(!(line = br.readLine()).equals("0")){
            n = Integer.parseInt(line);
            map = new int[n][n];

            StringTokenizer st = null;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cost = dijkstra();
            sb.append("Problem ").append(idx++).append(": ").append(cost).append("\n");


        }
        System.out.println(sb.toString());
    }
    public static int dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        q.add(new Node(0,0,map[0][0]));
        dist[0][0] = map[0][0];

        while(!q.isEmpty()){
            Node cur = q.poll();
            int px = cur.x;
            int py = cur.y;
            int cost = cur.cost;

            if(px == n-1 && py == n-1){
                return cost;
            }

            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if(cost+map[nx][ny] < dist[nx][ny]){
                    dist[nx][ny] = cost+map[nx][ny];
                    q.add(new Node(nx,ny,cost+map[nx][ny]));
                }
            }
        }
        return -1;
    }
}