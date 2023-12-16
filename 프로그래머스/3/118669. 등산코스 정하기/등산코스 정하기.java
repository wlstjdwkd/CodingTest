import java.util.*;
class Solution {
    public List<List<Node>> graph = new ArrayList<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        //단방향
        for(int[] path : paths){
            int s = path[0];
            int e = path[1];
            int cost = path[2];
            
            if(isGate(s, gates) || isSummit(e, summits)){
                graph.get(s).add(new Node(e, cost));
            }
            else if(isGate(e, gates) || isSummit(s, summits)){
                graph.get(e).add(new Node(s, cost));
            }
            else{
                graph.get(s).add(new Node(e, cost));
                graph.get(e).add(new Node(s, cost));
            }
        }
        
        answer = dijkstra(n, gates, summits);
        
        return answer;
    }
    private int[] dijkstra(int n, int[] gates, int[] summits){
        int[] intensity = new int[n+1];
        Queue<Node> q = new ArrayDeque<>();
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        for(int gate:gates){
            q.add(new Node(gate, 0));
            intensity[gate] = 0;
        }
        
        while(!q.isEmpty()){
            Node nn = q.poll();
            
            if(intensity[nn.v] < nn.cost){
                continue;
            }
            
            for(int i=0; i<graph.get(nn.v).size(); i++){
                Node u = graph.get(nn.v).get(i);
                
                int c = Math.max(intensity[nn.v], u.cost);
                if(intensity[u.v]> c){
                    intensity[u.v] = c;
                    q.add(new Node(u.v, c));
                }
            }
        }
        
        int sv = 0;
        int smin = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        
        for(int summit : summits){
            if(intensity[summit] < smin){
                smin = intensity[summit];
                sv = summit;
            }
        }
        
        int[] ans = {sv, smin};
        return ans;
    }
    private boolean isGate(int v, int[] gates){
        for(int gate : gates){
            if(v==gate) return true;
        }
        return false;
    }
    private boolean isSummit(int v, int[] summits){
        for(int summit : summits){
            if(v == summit) return true;
        }
        return false;
    }
    private class Node{
        int v, cost;
        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
}