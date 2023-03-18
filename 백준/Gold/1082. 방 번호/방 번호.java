import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N , P[],M;
    static int min, idx;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        min = 50;
        idx = -1;
        P = new int [N];
        for(int i=0; i<N; i++){
            P[i] = Integer.parseInt(st.nextToken());
            if(min>=P[i]){
                min = P[i];
                idx = i;
            }
        }
        M= Integer.parseInt(br.readLine());
        char[] digits = new char[51];
        //자리수
        int cnt=0;
        while(M>=min){
            digits[cnt++] = (char)(idx+'0');
            M-=min;
        }
        int s = 0;
        for(int i=0; i<cnt; i++){
            for(int j=N-1; j>=0; j--){
                if(P[j]-min <=M){
                    digits[i] = (char)(j+'0');
                    M-=(P[j] -min);
                    break;
                }
            }
            //첫번째 자리수 부터 안바뀌면 다시 M에 min채워주기
            if (digits[s] == '0') {

                s++;
                M+=min;
            }
        }
        if(s==cnt){
            System.out.println(0);
            return;
        }
        String answer="";
        for(int i= s; i<cnt; i++){
            answer+=digits[i];
        }
        System.out.println(answer);

    }
}