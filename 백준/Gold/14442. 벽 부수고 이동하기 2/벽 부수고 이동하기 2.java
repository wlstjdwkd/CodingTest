import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

    private static boolean isArea(int x, int y){
        return 0<= x && x<n && 0<=y && y<m;
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        k = stoi(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m][k+1];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        ans = -1;

        bfs();

        System.out.println(ans);
    }

    private static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1,0));
        visit[0][0][0] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            if(x == n-1 && y == m-1){
                ans = cur.dist;
                return;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isArea(nx, ny)){
                    if(map[nx][ny] == 0 && !visit[nx][ny][cur.boom]){
                        visit[nx][ny][cur.boom] = true;
                        q.add(new Node(nx,ny,cur.dist+1,cur.boom));
                    }

                    else{
                        if(cur.boom < k && !visit[nx][ny][cur.boom+1]){
                            visit[nx][ny][cur.boom+1] = true;
                            q.add(new Node(nx,ny,cur.dist+1,cur.boom+1));
                        }
                    }
                }
            }
        }
    }

    private static final int[] dx = {-1,1,0,0};
    private static final int[] dy = {0,0,-1,1};
    private static int[][] map;
    private static boolean[][][] visit;
    private static int n,m,k,ans;

    private static class Node{
        int x, y, dist, boom;
        public Node(int x, int y, int dist, int boom){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.boom = boom;
        }
    }


}