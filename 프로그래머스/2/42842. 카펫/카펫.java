class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int column = 1; column<= yellow; column++){
            int row = yellow/column;
            
            if(yellow%column == 0 && ((row+column) * 2 + 4)== brown){
                return new int[]{row+2, column+2};
            }
        }
        
        return null;
    }
}