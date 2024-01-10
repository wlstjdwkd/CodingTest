import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] =Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;
        while(start<=N && end<=N){
            if(total>=S &&min>end-start){
                min = end-start;
            }
            if(total<S){
                total+=nums[end++];
            }
            else{
                total-=nums[start++];
            }
        }

        if(min==Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(min);
        }
    }

}