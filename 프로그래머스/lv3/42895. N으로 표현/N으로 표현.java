class Solution {
    private int answer;
    
    public int solution(int N, int number) {
        // int answer = 0;
        answer = Integer.MAX_VALUE;
        dfs(N, number, 0,0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    private void dfs(int n, int number, int cnt, int prev){
        if(cnt > 8){
            answer = -1;
            return;
        }
        if(prev == number){
            answer = Math.min(answer, cnt);
            return;
        }
        int tempN = n;
        for(int i=0; i<8-cnt; i++){
            int newCount = cnt + i + 1;
            dfs(n, number, newCount, prev + tempN);
			dfs(n, number, newCount, prev - tempN);
			dfs(n, number, newCount, prev / tempN);
			dfs(n, number, newCount, prev * tempN);
            // dfs(n, number, newCount, tempN*10 + n);
			tempN = tempN * 10 + n;
        }
    }
    
}