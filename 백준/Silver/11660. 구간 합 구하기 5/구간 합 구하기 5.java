import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int sum=0;
        arr= new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j]=arr[i][j-1]+Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            sum=0;
            for(int j=x1; j<=x2; j++){
                sum+=(arr[j][y2]-arr[j][y1-1]);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}
