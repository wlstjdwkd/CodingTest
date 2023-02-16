import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int L,C;
    static String[] input;
    static boolean[] visit;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        input = new String[C];
        visit = new boolean[C];
        for(int i=0; i<C; i++){
            input[i] = st.nextToken();
        }
        Arrays.sort(input);
        arr= new String[L];
        combi(0,0);
        System.out.println(sb);
    }
    private static void combi(int start, int depth){
        if(depth == L){
            int cnt=0;
            int cnt2=0;
            StringBuilder sb2 = new StringBuilder();
            for(String val : arr){
                if(val.equals("a")||val.equals("e")||val.equals("i")||val.equals("o")||val.equals("u")){
                    sb2.append(val);
                    cnt=1;
                }
                else{
                    sb2.append(val);
                    cnt2++;
                }
            }
            if(cnt==1&& cnt2>=2){
                sb.append(sb2.toString());
                sb.append("\n");

            }
            return;
        }
        for(int i=start; i<C; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = input[i];
                combi(i, depth+1);
                visit[i] = false;
            }
        }
    }
}
