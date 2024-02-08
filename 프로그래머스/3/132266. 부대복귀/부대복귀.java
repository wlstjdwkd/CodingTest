import java.util.*;

class Solution {
    public List<List<Integer>> graph = new ArrayList<>();
    int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        dijkstra(n, destination);
        
        for(int i=0; i<sources.length; i++){
            if(dist[sources[i]] < Integer.MAX_VALUE){
                answer[i] = dist[sources[i]];
            }
            else{
                answer[i] = -1;
            }
        }
        
        
        return answer;
    }
    
    public void dijkstra(int n, int destination){
        dist = new int[n+1];
        
        Queue<Integer> q = new ArrayDeque<>();
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[destination] = 0;
        q.add(destination);
        while(!q.isEmpty()){
            int s = q.poll();
            
            for(int i=0; i<graph.get(s).size(); i++){
                int next = graph.get(s).get(i);
                if(dist[s]+1 < dist[next]){
                    dist[next] = dist[s]+1;
                    q.add(next);
                }
            }
        }
        
    }
}