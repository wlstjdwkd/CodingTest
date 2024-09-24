import java.awt.*;
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
        map = new char[n][m];
        group = new int[n][m];
        int index = 1;

        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == '0' && group[i][j] == 0){
                    hm.put(index, bfs(i,j,index));
                    index++;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(mapCount(i,j));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int mapCount(int x, int y){
        int sum = 1;
        Set<Integer> set = new HashSet<>();

        if(map[x][y] == '0'){
            return 0;
        }

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y + dy[i];
            if(isArea(nx,ny)){
//                if(group[nx][ny] == 0){
//                    continue;
//                }

                if(map[nx][ny] == '0'){
                    set.add(group[nx][ny]);
                }
            }
        }

        for(int ind : set){
            sum += hm.get(ind);
        }

        return sum%10;
    }

    private static int bfs(int s, int e, int groupNum){
        int count = 1;
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(s, e));
        group[s][e] = groupNum;

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if(isArea(x,y)){
                    if(map[x][y] == '0' && group[x][y] == 0){
                        q.add(new Point(x, y));
                        group[x][y] = groupNum;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static int n,m;
    private static char[][] map;
    private static final int[] dx = {0,0,-1,1};
    private static final int[] dy = {1,-1,0,0};
    private static int[][] group;
    private static Map<Integer, Integer> hm = new HashMap<>();


}