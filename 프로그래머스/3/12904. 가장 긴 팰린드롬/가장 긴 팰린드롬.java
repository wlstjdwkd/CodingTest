class Solution
{
    public int solution(String s)
    {
        int n = s.length();
        
        for(int i=n; i>=1; i--){
            for(int j=0; j<=n-i; j++){
                boolean flag = true;
                for(int k=0; k<i/2; k++){
                    if(s.charAt(j+k) != s.charAt(j+i-k-1)){
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                    return i;
                }
            }
        }
        

        return 1;
    }
}