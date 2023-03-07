import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static List<Node> list[];
    static boolean visit[];
    static int result;

    static class Node{
        int num;
        int weight;
        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Node>();
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,w));
            list[to].add(new Node(from,w));
        }
        result=0;
        for(int i=1; i<=n; i++){
            visit = new boolean[n+1];
            visit[i]= true;
            dfs(i,0);
        }
        System.out.println(result);
    }
    private static void dfs(int num, int max){
        for(Node node : list[num]){
            if(!visit[node.num]){
                visit[node.num]=true;
                dfs(node.num, max+ node.weight);
            }
        }
        result = (result<max)? max:result;
    }
}