import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int w,h;
    static int[][] graph;
    static int[] dx = {0,0,1,-1,-1,1,-1,1};
    static int[] dy = {1,-1,0,0,-1,1,1,-1};
    static boolean[][] check;
    static int count;
    public static void main(String[] args) throws IOException {
        while(true){
            st=new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h== 0){
                break;
            }
            graph = new int[h][w];
            check = new boolean[h][w];
            for(int i=0; i<h; i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            count=0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(graph[i][j]==1 && !check[i][j]){
                        search(i,j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    private static void search(int x, int y){
        check[x][y] = true;
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<h && ny<w){
                if(graph[nx][ny] == 1 && !check[nx][ny]){
                    search(nx,ny);
                }
            }
        }
    }
}