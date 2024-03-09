import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position implements Comparable<Position>{
    int posNum;
    int weight;

    Position(int posNum, int weight){
        this.posNum = posNum;
        this.weight = weight;
    }

    @Override
    public int compareTo(Position o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int n,m,r;
    static int[] dist;
    static int[] item;
    static ArrayList<ArrayList<Position>>a;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        a = new ArrayList<>();
        for(int i=0; i<=n; i++){
            a.add(new ArrayList<>());
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            a.get(x).add(new Position(y,l));
            a.get(y).add(new Position(x,l));
        }

        dist = new int[n+1];
        check = new boolean[n+1];
        int ans = 0;
        for(int i=1; i<=n; i++){
            ans = Math.max(ans, dijkstra(i));
        }


        System.out.println(ans);
    }

    public static int dijkstra(int start){
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check, false);

        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.add(new Position(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Position cur = pq.poll();
            int pos = cur.posNum;
            if(!check[pos]){
                check[pos] = true;
                for(Position position : a.get(pos)){
                    if(dist[position.posNum] > dist[pos] + position.weight){
                        dist[position.posNum] = dist[pos] + position.weight;
                        pq.add(new Position(position.posNum, dist[position.posNum]));
                    }
                }
            }
        }

        int res = 0;

        for(int i=1; i<=n; i++){
            if(dist[i] <=m){
                res += item[i];
            }
        }
        return res;
    }
}