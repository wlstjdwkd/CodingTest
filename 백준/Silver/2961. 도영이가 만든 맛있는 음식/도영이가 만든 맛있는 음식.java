import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int sour,bitter;
    static int[][] arr;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr= new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
        dfs(0,0,1,0);
        System.out.println(min);
    }

    private static void dfs(int cnt, int depth, int sourSum, int bitterSum){
        if(depth==N){
            if(cnt!=0){
                min = Math.min(min,Math.abs(sourSum-bitterSum));

            }
            return;
        }
        dfs(cnt+1, depth+1,sourSum*arr[depth][0], bitterSum+arr[depth][1]);
        dfs(cnt, depth+1,sourSum,bitterSum);
    }
}
