import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
//         String answer = "";
//         // Queue<Integer> pq = new PriorityQueue<>();
//         String[] answer2 = new String[n];
//         Stack<Integer> stack = new Stack<>();
//         for(int i=0; i<n; i++){
//             // pq.add(i);
//             Arrays.fill(answer2,"O");
//         }
//         for(int i=0; i<cmd.length; i++){
//             if(cmd[i].length()==3){
//                 //D OR U
//                 int num = cmd[i].charAt(2) - '0';
                
//                 if(cmd[i].charAt(0)=='D'){
//                     //D 다운
//                     while(num>0){
//                         if(answer2[k+1].equals("O")){
//                             num--;
//                         }
//                             k++;
                        
//                     }
//                 }
//                 else{
//                     //U 업
//                     while(num>0){
//                         if(answer2[k-1].equals("O")){
//                             num--;
//                         }
//                         k--;
//                     }
//                 }
//             }
//             else{
//                 //C OR Z
//                 if(cmd[i].charAt(0)=='C'){
//                     //C 삭제
//                     answer2[k]="X";
//                     stack.push(k);
//                     if(k!=n-1){
//                         //마지막 행이 아니면
//                         k++;
//                     }
//                     else{
//                         k--;
//                     }
//                 }
//                 else{
//                     //Z 복구
//                     answer2[stack.pop()]="O";
//                 }
//             }
//         }
//         answer = String.join("",answer2);
//         return answer;
        
        StringBuilder builder = new StringBuilder();
        int rowNum = n;
        Stack<Integer> deleted = new Stack<>();
        
        for(String tmp : cmd){
            if(tmp.length() > 1){
                //U OR D
                int x = Integer.parseInt(tmp.substring(2));
                if(tmp.charAt(0) == 'U') k -= x;
                else k += x;
            } else if (tmp.charAt(0) == 'C'){
                deleted.push(k);
                rowNum--;
                if(rowNum == k) k--;
            } else {
                rowNum++;
                if(deleted.pop() <= k) k++;
            }
        }
        
        for(int i = 0 ; i < rowNum ; i++)
            builder.append("O");
        while(!deleted.empty())
            builder.insert(deleted.pop(), "X");
        
        return builder.toString();
    }
}