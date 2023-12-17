class Solution {
    boolean[][] pillar;
    boolean[][] beam;
    int count;
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        beam = new boolean[n+1][n+1];
        
        for(int[] b : build_frame){
            int c = b[0];
            int r = b[1];
            int type = b[2];
            int constructionType = b[3];
            
            if(type==0){
                //기둥
                if(constructionType == 1 && canConstructPillar(r,c)){
                    //설치 가능
                    pillar[r][c] = true;
                    count++;
                }
                else if(constructionType == 0){
                    //파괴
                    pillar[r][c]= false;
                    if(!canDelete(n)){
                        //파괴 못함
                        pillar[r][c] = true;
                    }
                    else{
                        //파괴 가능
                        count--;
                    }
                }
            }
            else{
                //보
                if(constructionType == 1 && canConstructBeam(r,c)){
                    //보 설치 가능
                    beam[r][c] = true;
                    count++;
                }
                else if (constructionType == 0){
                    //삭제
                    beam[r][c] = false;
                    if(!canDelete(n)){
                        //삭제 불가능
                        beam[r][c] = true;
                    }
                    else{
                        //삭제 가능 
                        count--;
                    }
                }
            }
        }
        int[][] answer = new int[count][3];
        int idx = 0;
        for(int c=0; c<=n; c++){
            for(int r=0; r<=n; r++){
                if(pillar[r][c]){
                    answer[idx][0] = c;
                    answer[idx][1] = r;
                    answer[idx++][2] = 0;
                }
                if(beam[r][c]){
                    answer[idx][0] = c;
                    answer[idx][1] = r;
                    answer[idx++][2] = 1;
                }
            }
        }
        
        return answer;
    }
    
    private boolean canConstructBeam(int r, int c){
        //보 설치 가능 유무
        //한쪽 끝부분 기둥 위 or 양쪽 끝부분 보와 ehdtl 연결
        return (r>0 && pillar[r-1][c]) || (r>0 && pillar[r-1][c+1]) || (c>0 && beam[r][c-1] && beam[r][c+1]);
    }
    
    private boolean canDelete(int n){
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(pillar[i][j] && !canConstructPillar(i,j)) return false;
                if(beam[i][j] && !canConstructBeam(i,j)) return false;
            }
        }
        return true;
    }
    
    private boolean canConstructPillar(int r, int c){
        //기둥 설치 가능 유무
        //바닥 위 or 보 위 or 다른 기둥 위
        return r==0 || (r>0 && pillar[r-1][c]) || beam[r][c] || (c>0 && beam[r][c-1]);
    }
}