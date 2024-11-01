import java.util.*;

class Solution {
    private int[] numbers;
    private String[] operations;
    private int[][][] dp;
    
    public int solution(String arr[]) {
        int answer = -1;
        
        int n = arr.length/2;
        dp = new int[2][200][200];
        numbers = new int[n+1];
        operations = new String[n];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                dp[0][i][j] = Integer.MIN_VALUE;
                
                dp[1][i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0; i<arr.length; i++){
            if(i%2 == 0){
                numbers[i/2] = Integer.parseInt(arr[i]);
                
            }
            else{
                operations[i/2] = arr[i];
            }
        }
        
        
        
        return calculate(0,0,n);
    }
    
    private int calculate(int flag, int start, int end){
        if(start == end){
            dp[flag][start][end] = numbers[start];
            return dp[flag][start][end];
        }
        
        if(dp[flag][start][end] != Integer.MIN_VALUE && dp[flag][start][end] != Integer.MAX_VALUE){
            return dp[flag][start][end];
        }
        
        dp[flag][start][end] = 0;
        
        int result = flag==0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        if(flag == 0){
            for(int mid=start; mid<end; mid++){
                if(operations[mid].equals("-")){
                    result = Math.max(result, calculate(0,start,mid) - calculate(1,mid+1,end));
                }
                else{
                    result = Math.max(result, calculate(0,start,mid) + calculate(0,mid+1,end));
                }
            }
        }
        else{
            for(int mid=start; mid<end; mid++){
                if(operations[mid].equals("-")){
                    result = Math.min(result, calculate(1,start,mid) - calculate(0,mid+1,end));
                }
                else{
                    result = Math.min(result, calculate(1,start,mid) + calculate(1,mid+1,end));
                }
            }
        }
        
        dp[flag][start][end] = result;
        return dp[flag][start][end];
    }
}