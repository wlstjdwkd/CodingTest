import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M, dotNum, min;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc=1;
        String input = "";
        while((input=br.readLine())!=null){
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            dotNum=0;
            min = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                String s =br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j] = s.charAt(j);
                    if(map[i][j]=='.'){
                        dotNum++;
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]!= '*'){
                        boolean[][] visited = new boolean[N][M];
                        visited[i][j] = true;
                        dfs(i,j,visited,1,0);
                        visited[i][j] = false;
                    }
                }
            }

            if(min == Integer.MAX_VALUE){
                System.out.println("Case "+tc+": -1");
            }
            else{
                System.out.println("Case "+tc+": "+min);
            }
            tc++;
        }
    }
    private static void dfs(int r, int c, boolean visit[][], int dot, int edge){
        if(dot == dotNum){
            min = Math.min(min, edge);
            return;
        }

        for(int k=0; k<4; k++){
            int cnt= 0;
            int cr = r;
            int cc = c;
            while(true){
                int nr = cr + dr[k];
                int nc = cc + dc[k];

                if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='*' || visit[nr][nc]) break;

                cr = nr;
                cc = nc;
                visit[nr][nc] = true;
                cnt++;
            }

            if(r==cr && c==cc){
                continue;
            }
            else{
                dfs(cr,cc,visit,dot+cnt,edge+1);

                for(int d=1; d<=cnt; d++){
                    int y = r+dr[k] *d;
                    int x = c+dc[k] * d;
                    visit[y][x] = false;
                }
            }
        }
    }
}