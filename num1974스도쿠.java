import java.util.Scanner;
public class num1974스도쿠 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] board = new int[9][9];
        for(int tc=1; tc<=T; tc++){
            int ans=1;
            for(int i =0; i<9; i++){
                for(int j=0; j<9; j++){
                    board[i][j] = sc.nextInt();

                }
            }

            //row, col 검사
            for(int i=0; i<9; i++){
                int rsum=0;
                int csum=0;
                for(int j=0; j<9; j++){
                    rsum+=board[i][j];
                    csum+=board[j][i];
                }
                if(rsum!=45 || csum !=45){
                    ans=0;
                    break;
                }
            }

            //유효하지 않은 경우 검사 stop
            if(ans==0){
                System.out.println("#"+tc+" 0");
                continue;
            }

            //정사각형 구역 검사
            for(int i=0; i<9; i+=3){
                for(int j=0; j<9; j+=3){
                    int sum=0;
                    for(int x=0; x<3; x++){
                        for(int y=0; y<3; y++){
                            sum+=board[i+x][j+y];
                        }
                    }
                    if(sum!=45){
                        ans=0;
                        break;
                    }
                }
                if(ans==0) break;
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}
