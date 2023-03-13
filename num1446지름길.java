import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class num1446지름길 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,D, distance[], INF;
    static ArrayList<ArrayList<Point>> graph;
    static class Point{
        int end, value;

        public Point(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        distance = new int[10001];
        graph = new ArrayList<>();

        for(int i=0; i<10001; i++){
            distance[i]=i;
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortcutLen = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Point(end,shortcutLen));

        }
        dijkstra(0);
    }
    private static void dijkstra(int start){
        if(start>D){
            //도착지보다 시작지가 더 넘어서면
            return;
        }
        if(distance[start+1]>distance[start]+1){

            distance[start+1] = distance[start]+1;
        }
        for(int i=0; i<graph.get(start).size(); i++){

            if(distance[start]+graph.get(start).get(i).value
                    < distance[graph.get(start).get(i).end]){
                distance[graph.get(start).get(i).end]
                        = distance[start]+graph.get(start).get(i).value;
            }
        }
        dijkstra(start+1);
    }
}
