import java.util.*;

class Solution {
    private int n;
    private List<int[]> diceComb = new ArrayList<>();
    private int[][] diceR;
    
    public int[] solution(int[][] dice) {
        diceR = dice;
        //이거 dice 전역변수로 바꾸자
        int[] answer = {};
        n = dice.length;
        combineDice(0,0, new int[n/2]);
        
        int maxWinCnt = 0;
        for(int[] aComb : diceComb){
            List<Integer> aScores = new ArrayList<>();
            combineScores(0, 0, aComb, aScores);
            Collections.sort(aScores);
            
            int[] bComb = getBComb(aComb);
            List<Integer> bScores = new ArrayList<>();
            combineScores(0,0, bComb, bScores);
            Collections.sort(bScores);
            
            int winCnt = getWinCntOfA(aScores, bScores);
            if(maxWinCnt < winCnt){
                maxWinCnt = winCnt;
                answer=aComb;
            }
            
        }
        for(int i=0; i<answer.length; i++){
            answer[i]++;
        }
        
        
        return answer;
    }
    
    private int getWinCntOfA(List<Integer> aScores, List<Integer> bScores){
        int winCnt = 0;
        for(int s : aScores){
            int start = 0;
            int end = bScores.size() - 1;
            while(start<=end){
                int mid = (start+end)/2;
                
                if(s>bScores.get(mid)){
                    start = mid+1;
                }
                else{
                    end = mid -1;
                }
            }
            winCnt += start;
        }
        return winCnt;
    }
    
    private void combineScores(int cnt, int sum, int[] comb, List<Integer> scores){
        
        if(cnt == n/2){
            scores.add(sum);
            return;
        }
        
        for(int i=0; i<6; i++){
            combineScores(cnt+1, sum + diceR[comb[cnt]][i], comb, scores);
        }
    }
    
    private void combineDice(int start, int cnt, int[] numbers){
        if(cnt == n/2){
            diceComb.add(numbers.clone());
            return;
        }
        
        for(int i=start; i<n; i++){
            numbers[cnt] = i;
            combineDice(i+1, cnt+1, numbers);
        }
    }
    
    private int[] getBComb(int[] aComb){
        boolean[] isA = new boolean[n];
        for(int num : aComb){
            isA[num] = true;
        }
        
        int b = 0;
        int[] bComb = new int[n/2];
        for(int i=0; i<n; i++){
            if(!isA[i]){
                bComb[b] = i;
                b++;
            }
        }
        
        return bComb;
    }
}