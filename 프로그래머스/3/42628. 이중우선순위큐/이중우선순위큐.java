import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        Queue<Integer> q = new PriorityQueue<>();
        Queue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        int maxcnt = 0;
        int cnt = 0;
        for(String oper : operations){
            StringTokenizer st = new StringTokenizer(oper, " ");
            String s = st.nextToken();
            switch(s){
                case "I":
                    String next = st.nextToken();
                    q.add(Integer.parseInt(next));
                    maxq.add(Integer.parseInt(next));
                    break;
                    
                case "D":
                    if(q.size() == 0){
                        st.nextToken();
                    }
                    else if(st.nextToken().equals("1")){
                        //최댓값
                        q.remove(maxq.poll());
                    }
                    else{
                        maxq.remove(q.poll());
                    }
                    break;
            }
        }
        
        if(q.size() != 0){
            answer[1] = q.poll();
        }
        if(maxq.size()!= 0){
            answer[0] = maxq.poll();
        }
        
        return answer;
    }
}