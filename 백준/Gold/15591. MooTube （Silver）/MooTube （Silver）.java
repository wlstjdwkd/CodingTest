import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

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

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<R && 0<=y && y<C;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int Q = stoi(st.nextToken());

        List<int[]>[] adj = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int p = stoi(st.nextToken());
            int q = stoi(st.nextToken());
            int r = stoi(st.nextToken());

            adj[p].add(new int[]{q,r});
            adj[q].add(new int[]{p,r});
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            boolean[] visit = new boolean[N+1];
            visit[v] = true;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(v);

            int ans = 0;
            while(!q.isEmpty()){
                int cur = q.poll();

                for(int[] a : adj[cur]){
                    if(!visit[a[0]]){
                        if(a[1] >= k){
                            q.add(a[0]);
                            visit[a[0]] = true;
                            ans++;
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }


}