import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] a,b,c,d,p;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        a = new int[n+1];
        b = new int[n+1];
        c = new int[n+1];
        d = new int[n+1];
        p = new int[m+1];

        for(int i=1; i<=m; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=2; i<=m; i++){
            int prev = p[i-1];
            int next = p[i];

            if(prev>next){
                int temp = prev;
                prev = next;
                next = temp;
            }

            d[prev]++;
            d[next]--;
        }

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        long result =0, psum = 0;
        for(int i=1; i<n; i++){
            psum+=d[i];

            result += Math.min(psum*a[i], psum*b[i] + c[i]);
        }

        System.out.println(result);

    }

}