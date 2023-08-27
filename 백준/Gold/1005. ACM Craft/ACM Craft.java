import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,K;
    private static int[] delay;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            delay = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                delay[i] = Integer.parseInt(st.nextToken());
            }
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0; i<N+1; i++){
                list.add(new ArrayList<>());
            }
            int[] indegree = new int[N+1];

            while(K -- > 0){
                st = new StringTokenizer(br.readLine());
                // v1 -> v2
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list.get(v1).add(v2);
                indegree[v2]++;
            }
            int w = Integer.parseInt(br.readLine());

            topologicalSort(indegree, list, w);

        }
        System.out.println(sb);
    }

    private static void topologicalSort(int[] indegree, List<List<Integer>> list, int w) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] result = new int[N+1];

        // 건물의 소요 기본 소요시간은 d[i]
        for(int i=1; i<=N; i++) {
            result[i] = delay[i];

            if(indegree[i] == 0)
                q.offer(i);
        }

        // 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
        // Max 해주는 이유는 이전 테크가 다 올라야 현재 건물을 지을 수 있기 때문
        while(!q.isEmpty()) {
            int node = q.poll();

            for(Integer i : list.get(node)) {
                result[i] = Math.max(result[i], result[node] + delay[i]);
                indegree[i]--;

                if(indegree[i] == 0)
                    q.offer(i);
            }
        }
        sb.append(result[w]).append("\n");
    }
}