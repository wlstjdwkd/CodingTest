import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

//    private static boolean isArea(int x, int y){
//        return 1<=x && x<=m && 1<=y && y<=n;
//    }



    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());

        int[] maxDP = new int[3];
        int[] minDP = new int[3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            int x3 = stoi(st.nextToken());

            if(i == 0){
                maxDP[0] = minDP[0] = x1;
                maxDP[1] = minDP[1] = x2;
                maxDP[2] = minDP[2] = x3;
            }
            else{
                int beforeMaxDP_0 = maxDP[0];
                int beforeMaxDP_2 = maxDP[2];

                maxDP[0] = Math.max(maxDP[0], maxDP[1]) + x1;
                maxDP[2] = Math.max(maxDP[1], maxDP[2]) + x3;
                maxDP[1] = Math.max(Math.max(beforeMaxDP_0, maxDP[1]), beforeMaxDP_2) + x2;

                int beforeMinDp_0 = minDP[0], beforeMinDp_2 = minDP[2];
                minDP[0] = Math.min(minDP[0], minDP[1]) + x1;
                minDP[2] = Math.min(minDP[1], minDP[2]) + x3;
                minDP[1] = Math.min(Math.min(beforeMinDp_0, minDP[1]), beforeMinDp_2) + x2;


            }



        }

        System.out.print(Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]) + " ");
        System.out.println(Math.min(Math.min(minDP[0], minDP[1]), minDP[2]));
    }

}