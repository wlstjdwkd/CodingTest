import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2839설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int cnt=0;
        while(a>0){
            if(a%5==0){
                a-=5;
                cnt++;
            }
            else {
                a -= 3;
                cnt++;
            }
        }
        if(a==0){
            System.out.println(cnt);
        }
        else{
            System.out.println(-1);
        }
    }
}
