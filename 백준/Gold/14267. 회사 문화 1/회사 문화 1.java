import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int n,k;

    private static List<List<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            tree.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i=2; i<=n; i++){
            int parent = Integer.parseInt(st.nextToken());
            tree.get(parent).add(i);
        }

        int[] answer = new int[n+1];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            answer[node] += weight;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, 0});
        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int curNode = cur[0];
            int curWeight = answer[curNode];
            int totalWeight = cur[1];
            answer[curNode] += totalWeight;
            for(int nextNode : tree.get(curNode)){
                stack.push(new int[]{nextNode, curWeight + totalWeight});
            }
        }

        for(int i=1; i<=n; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}