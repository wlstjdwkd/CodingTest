import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for(int i=0; i<T; i++){
            st=new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max=1;

        for(int i=0; i<T; i++){
            while(!pq.isEmpty() && pq.peek() <=list.get(i).s){
                pq.poll();
            }
            pq.offer(list.get(i).e);
            max = Math.max(max,pq.size());
        }
        System.out.println(max);

    }
    static class Node implements Comparable<Node> {
        int n, s, e;

        public Node(int n, int s, int e) {
            this.n = n;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node n){
            if(this.s==n.s){
                return this.e-n.e;
            }
            return this.s-n.s;
        }

    }

}