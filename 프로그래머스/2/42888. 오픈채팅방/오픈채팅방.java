import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, Integer> userMap = new HashMap<>();
        ArrayList<String> userNick = new ArrayList<>();
        int[][] log = new int[record.length][2];
        int index = 0;
        int count = 0;
        
        for(int i = 0; i < record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String act = st.nextToken();
            String id = st.nextToken();
            switch(act){
                case "Enter":
                    if(!userMap.containsKey(id)){
                        userMap.put(id, index);
                        log[i][0] = index;
                        userNick.add(st.nextToken());
                        index++;
                    }
                    else{
                        userNick.set(userMap.get(id),st.nextToken());
                        log[i][0] = userMap.get(id);
                    }
                    log[i][1] = 1;
                    count++;
                    break;
                case "Leave":
                    log[i][0] = userMap.get(id);
                    log[i][1] = 2;
                    count++;
                    break;
                case "Change":
                    userNick.set(userMap.get(id), st.nextToken());
                    break;
            
            }
            
        }
        String[] answer = new String[count];
        index=0;
        for(int i=0; i<log.length; i++){
            if(log[i][1] == 1){
                answer[index++] = new StringBuilder().append(userNick.get(log[i][0])).append("님이 들어왔습니다.").toString();
            }
            else if(log[i][1] == 2){
                answer[index++] = new StringBuilder().append(userNick.get(log[i][0])).append("님이 나갔습니다.").toString();
            }
        }
        
        return answer;
    }
}