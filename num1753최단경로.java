import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class num1753최단경로 {

    // 정점의 정보를 담고 있는 Node class 선언
    static class Node{
        int idx, cost; // 정점의 번호와 우선순위(비용)를 저장한다.

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

    }

    public static int V,E,K; // 정점, 간선의 갯수와 시작점 K
    public static ArrayList<ArrayList<Node>> graph; // 2원 배열 선언
    public static int[] dist; // 정점간 이동횟수 카운트


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        V = in.nextInt();
        E = in.nextInt();
        K = in.nextInt();

        // 그래프 초기화 진행
        graph = new ArrayList<ArrayList<Node>>();

        // 정점의 갯수 만큼 그래프의 노드들을 초기화 한다.
        for(int i=0; i<V+1; i++){
            graph.add(new ArrayList<Node>());
        }

        // 정점의 번호와 우선순위를 담은 Node Instance들을 2차원 그래프 배열에 삽입한다.
        for(int i=0; i<E; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w= in.nextInt();

            graph.get(u).add(new Node(v, w));
        }

        // 정점 카운터 초기화
        dist = new int[V+1];

        // 정점 카운터를 4byte MAX값으로 초기화 진행
        for(int i=0; i<V+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소비용을 기준으로 다익스트라 알고리즘을 구성한다.
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        // 시작 정점에서 가장 짧은 정점은 시작 정점이다.
        queue.offer(new Node(K, 0));
        // 처음에는 시작 정점이 선택되므로 시작 정점에 0을 삽입한다.
        dist[K] = 0;

        // 우선순위 큐를 while 문으로 순회한다.
        while(!queue.isEmpty()){
            // 큐에서 요소를 추출한다.
            Node temp = queue.poll();

            // 해당 새로운 정점의 카운터가 새로운 정점의 우선순위보다 작다면 순회를 뛰어넘는다.
            if(dist[temp.idx] < temp.cost){
                continue;
            }

            // 선택된 정점의 주변 정점을 검색한다.
            for(int i=0; i<graph.get(temp.idx).size(); i++){
                Node nextNode = graph.get(temp.idx).get(i);
                // 주변 정점의 정점 카운터와 현재 정점의 우선순위+주변 정점의 우선순위를 비교해서 더 작은 값을 선택한다.
                if(dist[nextNode.idx] > temp.cost + nextNode.cost){
                    dist[nextNode.idx] = temp.cost+nextNode.cost;
                    queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

        // 정점 카운터를 순회하면서 각 정점에 도달하기 까지 걸린 거리를 출력한다.
        for(int i=1; i<V+1; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(dist[i]);
            }
        }

    }
}