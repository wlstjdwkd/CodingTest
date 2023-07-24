import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,L,R;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }
    public static int move(){
        int answer = 0;
        while(true){
            boolean isMove = false;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        int sum = bfs(i,j);
                        if(list.size() > 1){
                            changePolulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove){
                return answer;
            }
            answer++;
        }
    }

    public static int bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        list = new ArrayList<>();

        q.add(new Node(x,y));
        list.add(new Node(x,y));
        visited[x][y] = true;
        int sum = arr[x][y];
        while(!q.isEmpty()){
            Node current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(isInArea(nx,ny)&&!visited[nx][ny]){
                    int diff = Math.abs(arr[current.x][current.y]-arr[nx][ny]);
                    if(L <= diff && diff <= R){
                        q.add(new Node(nx,ny));
                        list.add(new Node(nx,ny));
                        sum += arr[nx][ny];
                        visited[nx][ny]= true;
                    }
                }
            }
        }
        return sum;
    }

    public static boolean isInArea(int x, int y){
        return 0<= x && x< N && 0<= y && y<N;
    }

    public static void changePolulation(int sum){
        int avg = sum/list.size();
        for(Node n : list){
            arr[n.x][n.y] = avg;
        }
    }

    public static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}