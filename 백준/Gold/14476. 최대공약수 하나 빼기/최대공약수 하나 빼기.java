import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int n = stoi(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+2];
        for(int i=1; i<=n; i++){
            arr[i] = stoi(st.nextToken());
        }

        int[] lgcd = new int[n+2];
        for(int i=1; i<=n; i++){
            lgcd[i] = gcd(arr[i], lgcd[i-1]);
        }

        int[] rgcd = new int[n+2];
        for(int i=n; i>0; i--){
            rgcd[i] = gcd(arr[i], rgcd[i+1]);
        }

        int ans = -1;
        int max = -1;
        for(int i=1; i<=n; i++){
            int res = gcd(lgcd[i-1], rgcd[i+1]);
            if(res > max){
                if(arr[i] % res != 0){
                    max = res;
                    ans = arr[i];
                }
            }

        }

        if(ans == -1){
            System.out.println(-1);
        }
        else{
            System.out.println(max + " " + ans);
        }

    }

    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }


}