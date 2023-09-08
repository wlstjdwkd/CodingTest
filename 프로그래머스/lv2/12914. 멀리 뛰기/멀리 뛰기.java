class Solution {
    public long solution(int n) {
        long[] arr = new long[n+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2; i<n+1; i++){
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %=1234567;
        }
        long answer = arr[n];
        
        return answer;
    }
}