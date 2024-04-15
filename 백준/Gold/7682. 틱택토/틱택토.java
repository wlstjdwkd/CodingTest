import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.equals("end")){
                break;
            }
            int xCnt = 0;
            int oCnt = 0;
            board = new char[3][3];
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    board[i][j] = s.charAt(i*3+j);
                    if(board[i][j]=='X'){
                        xCnt++;
                    }
                    if(board[i][j]=='O'){
                        oCnt++;
                    }
                }
            }

            if (xCnt + oCnt ==9 && xCnt - oCnt ==1){
                if(check('O') && check('X')){
                    sb.append("invalid\n");
                }
                else if(check('O')){
                    sb.append("invalid\n");
                }
                else{
                    sb.append("valid\n");
                }
            }
            else{
                if(check('X')&& check('O')){
                    sb.append("invalid\n");
                }
                else if(check('X') && xCnt - oCnt ==1){
                    sb.append("valid\n");
                }
                else if(check('O') && xCnt == oCnt){
                    sb.append("valid\n");
                }
                else {
                    sb.append("invalid\n");
                }
            }

        }
        System.out.println(sb);
    }

    private static boolean check(char tiktakto){
        for(int i=0; i<3; i++){
            int cnt = 0;
            int cnt2 = 0;
            for(int j=0; j<3; j++){
                if(board[i][j]==tiktakto){
                    cnt++;
                }
                if(board[j][i] == tiktakto){
                    cnt2++;
                }
            }
            if(cnt==3){
                return true;
            }
            if(cnt2==3){
                return true;
            }
        }
        if(board[0][0]==tiktakto && board[1][1]==tiktakto && board[2][2]==tiktakto){
            return true;
        }
        if(board[0][2]==tiktakto && board[1][1]==tiktakto && board[2][0]==tiktakto){
            return true;
        }

        return false;
    }
}