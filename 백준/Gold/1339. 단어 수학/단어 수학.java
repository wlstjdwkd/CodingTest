import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int[] alpha = new int[26];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        for(int i=0; i<N; i++){
            int len = arr[i].length();
            for(int j=0; j<len; j++){
                alpha[arr[i].charAt(j) - 'A'] += Math.pow(10, len-j-1);
            }
        }
        Arrays.sort(alpha);
        int index = 9;
        int sum = 0;
        for(int i=25; i>=0; i--){
            if(alpha[i] == 0){
                break;
            }
            sum += alpha[i] * index;
            index--;
        }
        System.out.println(sum);
    }
}