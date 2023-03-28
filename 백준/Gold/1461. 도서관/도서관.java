import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int len,N,M,maxAbs;
    static List<Integer> minus,plus;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minus = new ArrayList<>();
        plus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            maxAbs = Math.max(maxAbs,Math.abs(a));
            if(a>0){
                plus.add(a);
            }
            else{
                minus.add(Math.abs(a));
            }
        }
        Collections.sort(plus,Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        for(int i=0; i<plus.size(); i++){
            if(i%M==0&&plus.get(i)==maxAbs){
                len+=plus.get(i);
            }
            else if(i%M==0){
                len+=(plus.get(i)*2);
            }
        }
        for(int i=0; i<minus.size(); i++){
            if(i%M==0&&minus.get(i)==maxAbs){
                len+=minus.get(i);
            }
            else if(i%M==0){
                len += (minus.get(i)*2);
            }
        }
        System.out.println(len);

    }
}