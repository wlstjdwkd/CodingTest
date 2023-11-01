import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int A, B, C;
    static Set<Integer> answer = new TreeSet<>();
    static boolean[][] check = new boolean[201][201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(0,0,C);

        for(int num: answer){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
    static void dfs(int a, int b, int c){
        if(check[a][b]) return;
        if(a==0){
            answer.add(c);
        }
        check[a][b] = true;
        if(a + b > B){
            dfs((a+b)-B,B,c);
        }
        else{
            dfs(0, a+b, c);
        }

        if(a+b > A){
            dfs(A, a+b-A, c);
        }
        else{
            dfs(a+b, 0 ,c);
        }

        if(a+c > A){
            dfs(A, b, (a+c)-A);
        }
        else{
            dfs(a+c, b, 0);
        }

        if(a+c > C){
            dfs(a+c-C, b, C);
        }
        else{
            dfs(0, b, a+c);
        }

        if(b+c > B){
            dfs(a, B, (b+c)-B);
        }
        else{
            dfs(a, b+c, 0);
        }
        if(b+c > C){
            dfs(a, (b+c)-C, C);
        }
        else{
            dfs(a, 0, b+c);
        }

    }
}