import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    static int N;
    static List<String> ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(in.readLine());
        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(in.readLine());
            sb = new StringBuilder();
            dfs(1,1,0,1,"1");
            System.out.println(sb);
        }
    }

    public static void dfs(int idx, int num, int sum, int op, String express){
        if(idx == N){
            sum += (num*op);
            if(sum == 0){
                sb.append(express+"\n");
            }
            return;
        }
        dfs(idx+1,num*10+(idx+1),sum,op,express+" "+Integer.toString(idx+1));
        dfs(idx+1,idx+1,sum+(num*op),1, express+"+"+Integer.toString(idx+1));
        dfs(idx+1,idx+1,sum+(num*op),-1,express+"-"+Integer.toString(idx+1));
    }
}