import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int map[][];
    static int roomCount = 0;
    static int maxRoom = 0;
    static int wallRoom = 0;
    static int dx[] = {0,-1,0,1};
    static int dy[] = {-1,0,1,0};
    static boolean visited[][];
    static int wallCount[][][]; // 방의 번호와 이어진 방의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt((st.nextToken()));
        m = Integer.parseInt((st.nextToken()));
        map = new int[m][n];
        visited = new boolean[m][n];
        wallCount = new int[m][n][2];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    bfs(i,j,roomCount++);
                }
            }
        }

        MaxRoom();

        System.out.println(roomCount);
        System.out.println(maxRoom);
        System.out.println(wallRoom);

    }

    static void bfs(int x, int y, int id){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x,y));
        int tempRoom = 0;
        ArrayList<Point> back = new ArrayList<>();
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            tempRoom++;
            back.add(new Point(cur.x,cur.y));

            for(int i=0; i<4; i++){
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];

                if(tx < 0 || ty < 0 || tx >= m || ty >= n) continue;

                if(!visited[tx][ty]){
                    if((map[cur.x][cur.y] & (1<<i)) == 0){
                        visited[tx][ty] = true;
                        q.offer(new Point(tx,ty));
                    }
                }
            }
        }

        maxRoom = Math.max(maxRoom, tempRoom);

        for(Point p : back){
            wallCount[p.x][p.y][0] = id;
            wallCount[p.x][p.y][1] = tempRoom;
        }

    }

    static void MaxRoom(){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    int tx = i + dx[k];
                    int ty = j + dy[k];

                    if(tx < 0 || ty < 0 || tx >= m || ty >= n) continue;

                    if(wallCount[i][j][0] != wallCount[tx][ty][0]){
                        wallRoom = Math.max(wallRoom, wallCount[i][j][1] + wallCount[tx][ty][1]);
                    }
                }
            }
        }
    }
}