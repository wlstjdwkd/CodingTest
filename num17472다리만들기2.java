import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17472다리만들기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int islandCnt;
    static Queue<int[]> q;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parents;
    static class Node implements Comparable<Node>{
        int from;
        int end;
        int weight;

        public Node(int from, int end, int weight) {
            this.from = from;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n){
            return this.weight-n.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬 번호 할당
        //0과 1로 나누어지기 때문에 2부터 설정
        check = new boolean[N][M];
        islandCnt =2;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==1 && !check[i][j]) {
                    islandIndexing(j, i, islandCnt);
                    islandCnt++;
                }
            }
        }

        //섬 연결
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]!=0){
                    connect(j, i, map[i][j]);
                }
            }
        }

        islandCnt--;
        parents = new int[islandCnt];
        for(int i=1; i<islandCnt; i++){
            parents[i]=i;
        }
        int answer = shortestPath();
        System.out.println(answer == 0 ? -1 : answer);

    }

    private static void islandIndexing(int x, int y, int idx){
        q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        map[y][x] = idx;
        check[y][x] = true;

        while(!q.isEmpty()){
            int[] p = q.poll();
            int xx = p[0];
            int yy = p[1];

            for(int i=0; i<4; i++){
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if(nx>=0 && nx<M && 0<=ny && ny<N){
                    if(!check[ny][nx] && map[ny][nx]==1){
                        map[ny][nx] = idx;
                        check[ny][nx] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }


    //각 섬들 잇기
    private static void connect(int x, int y , int idx){
        q = new ArrayDeque<>();
        check = new boolean[N][M];
        for(int i=0; i<4; i++){
            q.add(new int[] {x,y,0});
            check[y][x] = true;

            while(!q.isEmpty()){
                int[] p =q.poll();
                int xx = p[0];
                int yy = p[1];
                int distance = p[2];

                int nx = xx+dx[i];
                int ny = yy+dy[i];

                if(0<=nx && nx <M && 0<=ny && ny <N ){
                    if(!check[ny][nx] && map[ny][nx] != idx){
                        //방문하지 않았고 시작 섬이 아닐 때
                        if(map[ny][nx] !=0) {
                            //다른 섬 도착
                            int from = idx - 1;
                            int to = map[ny][nx] - 1;
                            int bridgeLen = distance;
                            if (bridgeLen > 1) {
                                //다른 섬을 도착했지만 거리가 2이상이어야함
                                //진짜 이어질 루트 pq 저장
                                pq.add(new Node(from, to, bridgeLen));
                                break;
                            }
                        }
                        else{
                            //바다
                            check[ny][nx]=true;
                            q.add(new int[] {nx,ny,distance+1});
                        }

                    }
                }
            }
            //한 방향 다 봤으면 q클리어
            q.clear();
        }
    }

    private static int shortestPath() {
        int sum =0;
        int size = pq.size();
        for(int i=0; i< size; i++) {
            Node node = pq.poll();
            int x = node.from;
            int y = node.end;

            if(find(x) != find(y)) {
                sum += node.weight;
                union(x,y);
            }
        }

        int rx = parents[1];
        for(int i=2; i<islandCnt; i++) {
            if(rx != find(parents[i])) {
                return 0;
            }
        }

        return sum;
    }

    private static int find(int x) {
        if(parents[x] == x) return x;
        int rx = find(parents[x]);
        return rx;

    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x<y) {
            parents[y]=x;
        }
        else {
            parents[x] =y;
        }
    }
}