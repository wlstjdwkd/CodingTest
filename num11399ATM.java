import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num11399ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int[] arr = new int[a];
        for(int i=0; i<a; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=1; i<a; i++){
            arr[i] = arr[i-1]+ arr[i];
        }
        int sum=0;
        for(int i =0; i<a; i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
