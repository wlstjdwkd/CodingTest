import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        map = new int[N];

        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(ans, count(i));
        }
        System.out.println(ans);
    }
    public static int count(int idx){
        int cnt = 0;
        double tmp = 0;

        //왼쪽
        for(int i=idx-1; i>=0; i--){
            double slope = (double) (map[idx] - map[i]) / (idx - i);

            if( i == idx-1 || tmp>slope){
                cnt ++;
                tmp = slope;
            }
        }

        //오른쪽
        for(int i=idx+1; i<N; i++){
            double slope = (double) (map[idx] - map[i]) / (idx - i);

            if( i == idx+1 || tmp<slope){
                cnt ++;
                tmp = slope;
            }
        }

        return cnt;
    }
}