import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String vega = "(100+1+|01)+";
        for(int tc=0; tc<T; tc++){
            String answer = "NO";
            String s = br.readLine();
            if(s.matches(vega)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}