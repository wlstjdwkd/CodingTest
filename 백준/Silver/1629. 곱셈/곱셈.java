import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long A, B, C;
    private static long exp(long x, long n){
        if(n==1) return x%C;
        long y = exp(x, n/2);

        return n%2==0? y*y%C : (y*y%C)*x%C;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(exp(A,B));
    }
}
