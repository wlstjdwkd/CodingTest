class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        long[] seqMinusDP = new long[sequence.length];
        long[] seqPlusDP = new long[sequence.length];
        
        int minusStart = -1;
        int plusStart = 1;
        
        for(int i=0;  i<sequence.length; i++){
            if(i==0){
                seqMinusDP[i] = sequence[i] * minusStart;
                seqPlusDP[i] = sequence[i] * plusStart;
            }
            else{
                seqMinusDP[i] = Math.max(sequence[i]*minusStart, seqMinusDP[i-1] + sequence[i] * minusStart);
                seqPlusDP[i] = Math.max(sequence[i]*plusStart, seqPlusDP[i-1] + sequence[i] * plusStart);
            }
            
            minusStart*=-1;
            plusStart*=-1;
            
            answer = Math.max(answer, Math.max(seqMinusDP[i],seqPlusDP[i]));
        }
        
        return answer;
    }
}