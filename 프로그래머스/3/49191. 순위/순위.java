class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++){
            int A = results[i][0];
            int B = results[i][1];
            
            floyd[A][B] = 1;
            floyd[B][A] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                for(int j=1; j<=n; j++){
                    if(floyd[i][j] == 1 && floyd[j][k] == 1){
                        floyd[i][k] =1;
                        floyd[k][i] = -1;
                    }
                    
                    else if(floyd[i][j] == -1 && floyd[j][k] == -1){
                        floyd[i][k] =-1;
                        floyd[k][i] = 1;
                    }
                }
            }  
        }
        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                if(floyd[i][j] != 0){
                    cnt++;
                }
            }
            if(cnt == n-1){
                answer++;
            }
        }
        
        return answer;
    }
}