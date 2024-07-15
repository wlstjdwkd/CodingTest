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

    private static boolean isArea(int x, int y){
        return 0<= x && x<n && 0<=y && y<n;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        h = stoi(st.nextToken());
        d = stoi(st.nextToken());

        map = new char[n][n];
        check = new int[n][n];

        int startX = 0;
        int startY = 0;

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]== 'S'){
                    startX = i ;
                    startY = j ;
                }
            }
        }

        int ans = bfs(startX, startY);
        System.out.println(ans);
    }

    private static int bfs(int sx, int sy)
    {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(sx, sy, h,0,0));
        check[sx][sy] = h;

        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0; i<4; i++){
                int hp = cur.h;
                int cost = cur.cost;
                int cnt = cur.cnt;
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(isArea(nx,ny)){
                    if(map[nx][ny] == 'E'){
                        min = Math.min(min, cnt+1);
                        continue;
                    }

                    if(map[nx][ny] == 'U'){
                        cost = d;
                    }

                    if(cost!= 0){
                        cost--;
                    }
                    else{
                        hp--;
                    }

                    if(hp == 0){
                        continue;
                    }

                    if(check[nx][ny] < hp + cost){
                        check[nx][ny] = hp + cost;
                        q.add(new Node(nx,ny,hp, cost, cnt+1));
                    }
                }
            }
        }

        if(min == Integer.MAX_VALUE){
            return -1;

        }
        return min;
    }
    static int n,h,d;
    static char[][] map;
    static int[][] check;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Node{
        int x,y,h,cost,cnt;
        public Node(int x, int y, int h, int cost, int cnt){
            this.x = x;
            this.y = y;
            this.h = h;
            this.cost = cost;
            this.cnt = cnt;
        }
    }

}