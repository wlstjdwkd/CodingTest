import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {

        int n = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] weight = new int[n];
        for(int i = 0; i < n; i++){
            weight[i] = stoi(st.nextToken());
        }

        Arrays.sort(weight);

        int sum = 0;
        for(int i = 0; i < n; i++){
            if(sum + 1 < weight[i]){
                break;
            }
            sum += weight[i];
        }

        System.out.println(sum+1);

    }
}