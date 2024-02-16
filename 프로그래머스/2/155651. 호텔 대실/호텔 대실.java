import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int[][] bookTimeInt = new int[book_time.length][2];
        
        for(int i=0; i<book_time.length; i++){
            int startTime = Integer.parseInt(book_time[i][0].replace(":", ""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            endTime += 10;
            if(endTime%100 >= 60){
                endTime+=40;
            }
            
            bookTimeInt[i][0]=startTime;
            bookTimeInt[i][1] = endTime;
        }
        
        Arrays.sort(bookTimeInt, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]- b[0]);
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for(int[] timeArr : bookTimeInt){
            if(rooms.size()==0){
                rooms.add(timeArr[1]);
                continue;
            }
            
            int earliestEmptyRoom = rooms.peek();
            
            if(timeArr[0] >= earliestEmptyRoom){
                rooms.poll();
                rooms.add(timeArr[1]);
            }
            else{
                rooms.add(timeArr[1]);
            }
        }
        
        return rooms.size();
    }
}