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

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        Long[] arr = new Long[n];

        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for(int i=0; i<m; i++){
            sum += arr[i];
        }

        long max = sum;
        for(int j=0; j<n-m; j++){
            sum -= arr[j];
            sum += arr[j+m];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}