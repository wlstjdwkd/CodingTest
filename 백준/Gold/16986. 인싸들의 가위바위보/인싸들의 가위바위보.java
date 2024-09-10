import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<n && 0<=y && y<m;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        k = stoi(st.nextToken());
        used = new boolean[n+1];

        a = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                a[i][j] = stoi(st.nextToken());
            }
        }

        commands = new int[4][21];
        for(int i=2; i<=3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=20; j++){
                commands[i][j] = stoi(st.nextToken());
            }
        }
        permutation(1);

        System.out.println(flag ? "1" : "0");

    }

    private static void permutation(int depth){
        if(flag){
            return;
        }

        if(depth == n+1){
            if(gameStart()){
                flag = true;
            }
            return;
        }

        for(int i=1; i<=n; i++){
            if(!used[i]){
                used[i] = true;
                commands[1][depth] = i;
                permutation(depth+1);
                used[i] = false;
            }
        }
    }

    private static int n,k;
    private static int[][] a;
    private static int[][] commands;
    private static boolean[] used;
    private static boolean flag;

    private static boolean gameStart(){
        int[] winCnt = new int[4];
        int[] actionIndex = new int[4];
        Arrays.fill(actionIndex, 1);

        int player1 = 1, player2 = 2, nextPlayer = 3;

        while(true){
            nextPlayer = 6 - player1 - player2;
            if(winCnt[1] == k){
                return true;
            }

            if(winCnt[2] == k || winCnt[3] == k){
                return false;
            }

            if(actionIndex[1] == n+1 || actionIndex[2] == 21 || actionIndex[3] == 21){
                return false;
            }

            int winner = whoWin(player1, player2, actionIndex);
            winCnt[winner]++;
            actionIndex[player1]++;
            actionIndex[player2]++;

            //진 사람은 다음 판에
            player1 = winner;
            player2 = nextPlayer;

        }
    }

    private static int whoWin(int p1, int p2, int[] actionIndex){
        int action1 = commands[p1][actionIndex[p1]];
        int action2 = commands[p2][actionIndex[p2]];

        if(a[action1][action2] == 2){
            return p1;
        }
        else if(a[action1][action2] == 1){
            //비긴 경우에 뒷번호
            return Math.max(p1, p2);
        }
        else{
            return p2;
        }
    }


}