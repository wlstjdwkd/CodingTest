import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int k, w, h;
    static int[][] board;
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2}; //말이 이동할 수 있는 8방향
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx = {0, 1, 0 ,-1}; // 원숭이가 이동할 수 있는 4방향
    static int[] dy = {1, 0, -1, 0};
    static int min = Integer.MAX_VALUE;
    static boolean[][][] visited;

    static class Node{
        int x, y, count, k;
        Node(int x, int y, int count, int k){
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[h][w];
        visited = new boolean[h][w][k+1];

        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = bfs(0,0);

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static int bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y, 0, k));
        while(!q.isEmpty()){
            Node current = q.poll();
            if(current.x == h-1 && current.y == w-1){
                return current.count;
            }

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx>=0 && ny>=0 && nx<h && ny<w && board[nx][ny] != 1 && !visited[nx][ny][current.k]){
                    visited[nx][ny][current.k] = true;
                    q.add(new Node(nx, ny, current.count+1, current.k));
                }
            }

            if(current.k>0){
                for(int i=0; i<8; i++){
                    int nx = current.x + hdx[i];
                    int ny = current.y + hdy[i];
                    if(nx>=0 && ny>=0 && nx<h && ny<w && board[nx][ny] != 1 && !visited[nx][ny][current.k-1]){
                        visited[nx][ny][current.k-1] = true;
                        q.add(new Node(nx, ny, current.count+1, current.k-1));
                    }
                }
            }
        }
        return min;
    }
}