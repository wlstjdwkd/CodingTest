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

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<N && 0<=y && y<N;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] degree = new int[N+1];
        List<List<Integer>> a = new ArrayList<>();

        for(int i=0; i<=N; i++){
            a.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = stoi(st.nextToken());
            int last = stoi(st.nextToken());
            a.get(first).add(last);
            degree[last]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++){
            if(degree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");

            for(int next : a.get(now)){
                degree[next]--;

                if(degree[next] == 0){
                    pq.add(next);
                }
            }
        }

        System.out.println(sb.toString());
    }



}