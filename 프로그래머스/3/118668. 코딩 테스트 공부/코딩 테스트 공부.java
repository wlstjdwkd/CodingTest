class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int goal_a =0;
        int goal_c = 0;
        for(int i=0; i<problems.length; i++){
            goal_a = Math.max(goal_a, problems[i][0]);
            goal_c = Math.max(goal_c, problems[i][1]);
        }
        
        if(goal_a<=alp && goal_c<=cop){
            return 0;
        }
        
        if(goal_a<=alp){
            alp = goal_a;
        }
        if(goal_c <= cop){
            cop = goal_c;
        }
        
        int[][] dp = new int[goal_a+2][goal_c+2];
        
        for(int i=alp; i<=goal_a; i++){
            for(int j=cop; j<=goal_c; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
        for(int i=alp; i<=goal_a; i++){
            for(int j=cop; j<=goal_c; j++){
                //문제 안풀고 순수 공부시간으로 채웠을때 최소시간
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] p : problems){
                    if(i>=p[0] && j>=p[1]){
                        //문제를 풀 알고&코딩력이 됐음
                        if(i+p[2]>goal_a && j+p[3]> goal_c){
                            //이 문제 풀면 목표치 도달했음
                            dp[goal_a][goal_c] = Math.min(dp[goal_a][goal_c], dp[i][j]+p[4]);
                        }
                        else if(i+p[2]>goal_a){
                            //알고력만 달성했음
                                dp[goal_a][j+p[3]] = Math.min(dp[goal_a][j+p[3]],dp[i][j]+p[4]);
                        }
                        else if(j+p[3]>goal_c){
                            dp[i+p[2]][goal_c]=Math.min(dp[i+p[2]][goal_c],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]<=goal_a&&j+p[3]<=goal_c){
                           dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]); 
                        }
                    }
                }
            }
        }
        
        
        
        return dp[goal_a][goal_c];
    }
}