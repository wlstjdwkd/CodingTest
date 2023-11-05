class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        
        int[][] route = new int[n][m];
        route[0][0] = 1;
        
        for(int[] puddle : puddles){
            // 물 웅덩이 좌표의 x, y 가 반대로 나와있음
            route[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j< m; j++){
                
                if(route[i][j] == -1){
                    route[i][j] = 0;
                    continue;
                }
                
                // dp[x][y] = dp[x-1][y] + dp[x][y-1]
                // 맨 위가 아니라면
                if( i != 0 ){
                    route[i][j] += route[i-1][j] % mod; 
                }
                // 맨 아래가 아니라면
                if( j != 0 ){
                    route[i][j] += route[i][j-1] % mod;
                }
            }
        }
        
        answer = route[n-1][m-1] % mod;
        return answer;
    }
}