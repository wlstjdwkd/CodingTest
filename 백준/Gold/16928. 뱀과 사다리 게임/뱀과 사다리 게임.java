import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<N && 0<=y && y<N;
//    }

    private static int[] board;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        board = new int[101];

        for(int i=1; i<101; i++){
            board[i] = i;
        }

        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());

            board[x] = y;
        }

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());

            board[x] = y;
        }

        int result = bfs();

        System.out.println(result);
    }

    private static int bfs(){
        int[] check = new int[101];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        while(true){
            int visitedNum = q.poll();

            for(int i=1; i<=6; i++){
                int newNode = visitedNum + i;

                if(newNode > 100){
                    break;
                }

                if(check[board[newNode]] == 0){
                    q.add(board[newNode]);
                    check[board[newNode]] = check[visitedNum] + 1;
                }

                if(board[newNode] == 100){
                    return check[100];
                }
            }
        }
    }


}