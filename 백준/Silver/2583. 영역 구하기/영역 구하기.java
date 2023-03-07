import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,M,K;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int[][] arr;
    static int cnt;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int k=y1; k<y2; k++){
                for(int j=x1; j<x2; j++){
                    arr[k][j]=1;
                }
            }
        }
        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(arr[i][j]==0){
                    cnt=0;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i :list){
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
    private static void dfs(int r, int c){
        arr[r][c]=1;
        cnt++;
        for(int i=0; i<4; i++){
            int nx = r+dx[i];
            int ny = c + dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                if(arr[nx][ny]==0){
                    dfs(nx,ny);
                }
            }
        }
    }
}