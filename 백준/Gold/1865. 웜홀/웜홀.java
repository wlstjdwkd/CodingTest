import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static class Node{
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static boolean bellmanford(){
        int[] distance = new int[N+1];
        boolean update = false;
        for(int i=1; i<=N; i++){
            update = false;
            for(int cur=1; cur<=N; cur++){
                for(Node next : graph.get(cur)){
                    if(distance[next.node] > distance[cur]+ next.weight){
                        distance[next.node] = distance[cur] + next.weight;
                        update = true;
                    }
                }
            }

            if(!update){
                break;
            }
        }
        return update;
    }
    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        for(int t=1; t<=TC; t++){
            String answer="";
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for(int i=0; i<=N; i++){
                graph.add(new ArrayList<>());
            }

            for(int i=0; i< M; i++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.get(S).add(new Node(E,T));
                graph.get(E).add(new Node(S,T));
            }

            for(int i=0; i<W; i++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.get(S).add(new Node(E,-1*T));
            }

            if(bellmanford()){
                answer = "YES";
            }
            else{
                answer = "NO";
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}