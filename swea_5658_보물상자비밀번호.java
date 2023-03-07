import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class swea_5658_보물상자비밀번호 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int num;
    static int N,K;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            num=0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            String[] s = br.readLine().split("");
            TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());

            for(int i=0; i<N/4; i++){
                String temp = s[N-1];
                for(int j=N-1; j>0; j--){
                    s[j] = s[j-1];
                }
                s[0]= temp;
                for(int j=0;j<N; j+= N/4){
                    StringBuilder sb2 = new StringBuilder();
                    for (int k = j; k < j+(N/4); k++) {
                        sb2.append(s[k]);
                    }
                    set.add(sb2.toString());
                }
            }
            String[] result = set.toArray(new String[set.size()]);
            for(int i=0; i<result[K-1].length(); i++){
                int a=0;
                if(result[K-1].charAt(i)=='A'){
                    a=10;
                }
                else if(result[K-1].charAt(i)=='B'){
                    a=11;
                }
                else if(result[K-1].charAt(i)=='C'){
                    a=12;
                }
                else if(result[K-1].charAt(i)=='D'){
                    a=13;
                }
                else if(result[K-1].charAt(i)=='E'){
                    a=14;
                }
                else if(result[K-1].charAt(i)=='F'){
                    a=15;
                }
                else{
                    a= result[K-1].charAt(i)-'0';
                }
                num+= (a*Math.pow(16,Math.abs(N/4-i-1)));
            }
            sb.append("#").append(tc).append(" ").append(num).append("\n");
        }
        System.out.println(sb);
    }
}
