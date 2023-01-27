import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2292벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int start=0;
        int end=1;
        int cnt=1;

        while(true){
            if(start<= a&& a <= end){
                System.out.println(cnt);
                return;
            }
            start=end+1;
            end= end+cnt*6;
            cnt++;
        }

    }

}
