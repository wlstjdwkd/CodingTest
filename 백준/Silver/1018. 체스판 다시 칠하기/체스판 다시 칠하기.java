import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static String[] chessboard;

    private static int getMinCost(int startRow, int startCol){

        String[] board = {"WBWBWBWB", "BWBWBWBW"};

        int whiteCount = 0;

        for(int i=startRow; i<startRow+8; i++){
            for(int j=startCol; j<startCol+8; j++){
                if(chessboard[i].charAt(j) != board[i%2].charAt(j-startCol)){
                    whiteCount++;
                }
            }
        }

        return Math.min(whiteCount, 64-whiteCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chessboard = new String[N];

        for(int i=0; i<N; i++){
            chessboard[i] = br.readLine();
        }

        int count = Integer.MAX_VALUE;
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                int resultCount = getMinCost(i,j);

                count = Math.min(count, resultCount);
            }
        }
        System.out.println(count);
    }
}