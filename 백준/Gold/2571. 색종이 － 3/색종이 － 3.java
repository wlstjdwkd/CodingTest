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
//        return 0<= x && x<n && 0<=y && y<n;
//    }

    public static void main(String[] args) throws IOException {
        int n = stoi(br.readLine());

        final int SQUARE_LENGTH = 100;

        int[][] arr = new int[SQUARE_LENGTH+1][SQUARE_LENGTH+1];
        for(int[] row: arr){
            Arrays.fill(row, -10001);
        }
        
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int r = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            for(int i=r; i<r+10; i++){
                for(int j=c; j<c+10; j++){
                    arr[i][j] = 1;
                }
            }
        }
        
        int[][] prefixSum = new int[SQUARE_LENGTH+1][SQUARE_LENGTH+1];
        for(int i=1; i<=SQUARE_LENGTH; i++){
            for(int j=1; j<=SQUARE_LENGTH; j++){
                prefixSum[i][j] = arr[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }


        int answer = getAnswer(SQUARE_LENGTH, prefixSum);

        System.out.println(answer);
    }

    private static int getAnswer(int SQUARE_LENGTH, int[][] prefixSum) {
        int answer = 0;
        for(int i = 1; i<= SQUARE_LENGTH; i++){
            for(int j = 1; j<= SQUARE_LENGTH; j++){
                for(int ib = i+1; ib<= SQUARE_LENGTH; ib++){
                    for(int jb = j+1; jb<= SQUARE_LENGTH; jb++){
                        int area = prefixSum[ib][jb] - prefixSum[i-1][jb] - prefixSum[ib][j-1] + prefixSum[i-1][j-1];
                        if(area<0){
                            break;
                        }
                        
                        answer = Math.max(answer, area);
                    }
                }
            }
        }
        return answer;
    }

}