import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        return bfs(begin, target, words);
    }
    public int bfs(String begin, String target, String[] words){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.word.equals(target)) return cur.count;
            
            for(int i=0; i<words.length; i++){
                int match = 0;
                for(int j=0; j<begin.length(); j++){
                    if(cur.word.charAt(j) == words[i].charAt(j)){
                        match++;
                    }
                    
                    if(!visited[i] && match == begin.length()-1){
                        q.add(new Node(words[i], cur.count+1));
                        visited[i] = true;
                    }
                }
            }
        }
            return 0;
        
    }
}
class Node {
    String word;
    int count;
    Node(String word, int count){
        this.word = word;
        this.count = count;
    }
}