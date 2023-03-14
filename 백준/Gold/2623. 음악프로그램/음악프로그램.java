import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 1; j < num; j++) {
                int singer = Integer.parseInt(st.nextToken());
                a.get(before).add(singer);
                indegree[singer]++;

                before = singer;
            }
        }

        // 미리 인접리스트에서 사이클을 확인하기.
//        boolean[] recur = new boolean[N + 1];
//        for (int i = 1; i <= N; i++) {
//            boolean[] visited = new boolean[N + 1];
//            if (isCycle(a, i, visited, recur)) {
//                bw.write("0\n");
//                bw.flush();
//                bw.close();
//                br.close();
//                return;
//            }
//        }

        String ans = topologicalSort(a, indegree, N);

        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }

    // DFS를 이용한 사이클 찾기
//    public static boolean isCycle(ArrayList<ArrayList<Integer>> a, int start, boolean[] visited, boolean[] recur) {
//        visited[start] = true;
//        recur[start] = true;
//
//        for (int i : a.get(start)) {
//            if (!visited[i] && isCycle(a, i, visited, recur)) {
//                return true;
//            }else if(recur[i]) {
//                return true;
//            }
//        }
//        
//        recur[start] = false;
//        return false;
//    }

    // 위상 정렬
    public static String topologicalSort(ArrayList<ArrayList<Integer>> a, int[] indegree, int N) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int next : a.get(now)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // result의 size()가 N이 아니라는 말은 그래프에서
        // 사이클이 발생하였다는 의미이다.
        // 사이클이 있으면, indegree가 0인 node를 큐에 넣지 못하면서
        // N개의 결과를 채우기도 전에 반복문이 종료되기 때문이다.
        if (result.size() != N) {
            return "0\n";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + "\n");
        }

        return sb.toString();

    }
}