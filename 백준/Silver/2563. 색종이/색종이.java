import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int sum=0;
        boolean[][] arr = new boolean[101][101];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int a=x; a<x+10; a++){
                for(int b=y; b<y+10; b++){
                    if(!arr[a][b]){
                        sum++;
                        arr[a][b]=true;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
