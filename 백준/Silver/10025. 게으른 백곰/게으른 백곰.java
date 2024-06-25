import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken()) * 2 +1;

        int[] ice = new int[1000001];
        int g,x;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            g = stoi(st.nextToken());
            x = stoi(st.nextToken());
            ice[x] = g;
        }

        int sum = 0;
        int max = 0;
        for(int i=0; i<=1000000; i++){
            if(i-K>=0){
                sum -= ice[i-K];
            }
            sum += ice[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}