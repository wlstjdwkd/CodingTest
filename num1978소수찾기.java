import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1978소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b =br.readLine();
        StringTokenizer st = null;
        st = new StringTokenizer(b," ");
        int cnt=0;
        while(st.hasMoreTokens()){
            int c = Integer.parseInt(st.nextToken());
            if(c==2){
                cnt++;
            }
            else if(c>1){
                for(int i=2; i<c; i++){
                    if(c%i==0){
                        break;
                    }
                    if(i==c-1 && i%c==i){
                        cnt++;
                    }

                }

            }
        }
        System.out.println(cnt);
    }
}
