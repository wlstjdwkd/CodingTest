import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb =new StringBuilder();
    static int n,m;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        for(int i=1; i<=n; i++){
            parents[i]=i;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 0){
                union(a,b);

            }
            else{
                sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");

            }
        }
        System.out.println(sb);
    }

    //y의 부모를 x로 치환 x>y면 반대
    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }
    }
    //x부모 찾기ㅣ
    private static int find(int x){
        if(parents[x]==x) return x;
        return parents[x]=find(parents[x]);
    }
    // x와 y의 부모가 같은지 확인
    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        }

        return false;
    }
}