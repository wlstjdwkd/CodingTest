import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long[] pick = new long[3];
    static long max = 3_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<n-2; i++){
            solution(arr, i);
        }

        Arrays.sort(pick);

        for(int i=0; i<3; i++){
            System.out.print(pick[i]+" ");
        }

    }

    static void solution(long[] arr, int index){
        int left = index+1;
        int right = arr.length-1;

        while(left<right){
            long sum = arr[index] + arr[left] + arr[right];
            long absSum = Math.abs(sum);

            if(absSum < max){
                max = absSum;
                pick[0] = arr[index];
                pick[1] = arr[left];
                pick[2] = arr[right];
            }

            if(sum > 0){
                right--;
            }
            else{
                left++;
            }
        }
    }
}