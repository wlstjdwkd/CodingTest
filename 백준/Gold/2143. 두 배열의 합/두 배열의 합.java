import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n+1];
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            a[i] += a[i-1];
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m+1];
        for(int i=1; i<=m; i++){
            b[i] = Integer.parseInt(st.nextToken());
            b[i] += b[i-1];
        }

        int aSize = n*(n+1)/2;
        int bSize = m*(m+1)/2;
        long[] aSum = new long[aSize];
        int idx = 0;

        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                int av = a[j];
                if(i>1){
                    av -= a[i-1];
                }
                aSum[idx++] = av;
            }
        }

        long[] bSum = new long[bSize];
        idx = 0;
        for(int i=1; i<=m; i++){
            for(int j=i; j<=m; j++){
                int bv = b[j];
                if(i>1){
                    bv -= b[i-1];
                }
                bSum[idx++] = bv;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);
        int left = 0;
        int right = bSize-1;
        long cnt = 0;
        while(left<aSize && right>=0){
            long asv =aSum[left], bsv = bSum[right];
            long sum =asv + bsv;
            if(sum==T){
                long ac=0, bc=0;
                while(left<aSize && aSum[left] == asv){
                    left++;
                    ac++;
                }

                while(right>=0 && bSum[right] == bsv){
                    right--;
                    bc++;
                }

                cnt += ac*bc;
            }
            if(sum>T){
                right--;
            }
            else if(sum<T){
                left++;
            }
        }
        System.out.println(cnt);
    }
}