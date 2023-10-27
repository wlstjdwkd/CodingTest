import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        Queue<int []> q = new ArrayDeque<>();
        for(int i=0; i<computers.length; i++){
            if(check[i]){
                continue;
            }
            q.add(computers[i]);
            check[i] = true;
            while(!q.isEmpty()){
                int[] computer = q.poll();
                for(int j=0; j<computer.length; j++){
                    if(!check[j] && computer[j] == 1){
                        check[j] = true;
                        q.add(computers[j]);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}