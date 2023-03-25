import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;

        int min = Integer.MAX_VALUE;
        int left=0;
        int right = 0;
        int sum=0;

        while(end>start){
            sum=arr[start]+arr[end];
            if(min>Math.abs(sum)){
                min=Math.abs(sum);
                left = arr[start];
                right = arr[end];
            }
            if(sum>0){
                end--;
            }
            else{
                start++;
            }
        }
        System.out.println(left+" "+right);
    }

}