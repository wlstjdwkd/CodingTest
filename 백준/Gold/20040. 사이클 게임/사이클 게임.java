import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m, res, parents[];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n];

        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a)!=find(b)){
                union(a,b);
            }
            else{
                res = i+1;
                break;
            }

        }

        System.out.println(res);
    }

    private static int find(int x){
        if(parents[x] ==x){
            return x;
        }
        else{
            return parents[x]= find(parents[x]);
        }
    }
    private static void union(int x, int y){
        if(x<y){
            parents[find(y)] = parents[find(x)];
        }
        else{
            parents[find(x)] = parents[find(y)];
        }
    }
}