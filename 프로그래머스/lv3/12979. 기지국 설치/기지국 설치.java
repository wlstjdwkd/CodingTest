class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int now = 1;
        int st=0;
        while(now<=n){
            if(st<stations.length && now >= stations[st] - w){
                now = stations[st] + w +1;
                st++;
            }
            else{
                answer++;
                now+=(w*2)+1;
            }
        }
        

        return answer;
    }
    
}