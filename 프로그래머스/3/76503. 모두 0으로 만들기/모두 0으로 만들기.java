import java.util.*;
class Solution {
    long answer = 0;
    ArrayList<Integer>[] adjList;
    int len;
    boolean[] visited;
    long[] longAns;
    public long solution(int[] a, int[][] edges) {
        len = a.length;
        adjList = new ArrayList[len];
        visited = new boolean[len];
        longAns = new long[len];
        
        long s = 0;
        
        for(int i = 0; i<len; i++){
            longAns[i] = a[i];
            s += a[i];
            adjList[i] = new ArrayList<>();
        }
        
        if(s!=0){
            return -1;
        }
        
        for(int[] edge : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        dfs(0);
        
        return answer;
    }
    
    private long dfs(int index){
        visited[index] = true;
        
        for(int i=0; i<adjList[index].size(); i++){
            int curr = adjList[index].get(i);
            if(visited[curr] == false){
                longAns[index] += dfs(curr);
            }
        }
        
        answer += Math.abs(longAns[index]);
        
        return longAns[index];
    }
}