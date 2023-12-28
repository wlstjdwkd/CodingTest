class Solution {
    public int solution(int[] a) {
        int answer = 2;
        
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        //왼쪽 아니면 오른쪽에 큰수만 있어야함
        //더 작은수가 있다면 불가능
        int min = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++){
            min = Math.min(a[i],min);
            left[i] = min;
            
        }
        
        min= Integer.MAX_VALUE;
        for(int i=a.length-1; i>=0; i--){
            min = Math.min(a[i],min);
            right[i] = min;
            
        }
        
        for(int i=1; i<a.length-1; i++){
            if(left[i] >= a[i] || right[i] >=a[i]){
                answer++;
            }
        }
        
        
        return answer;
    }
}