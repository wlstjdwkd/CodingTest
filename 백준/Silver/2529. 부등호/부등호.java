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
    static StringBuilder sb= new StringBuilder();
    static int k;
    static char[] input;
    static boolean[] visit;
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        input = new char[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            input[i] = st.nextToken().charAt(0);
        }
        visit = new boolean[10];

        dfs("",0);
        Collections.sort(result);
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));
    }
    private static void dfs(String num, int depth){
        if(depth==k+1){
            result.add(num);
            return;
        }
        for(int i=0; i<10; i++){
            if(depth==0 || !visit[i] && compare(num.charAt(num.length()-1)-'0',i,input[depth-1])){
                visit[i] = true;
                dfs(num+i,depth+1);
                visit[i] = false;
            }
        }
    }
    private static boolean compare(int a, int b, char c){
        return c=='<' ? a<b : a>b;
    }
}
