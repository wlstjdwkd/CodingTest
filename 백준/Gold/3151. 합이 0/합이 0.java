import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = stoi(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);

        long cnt = 0;
        for(int i = 0; i < N; i++){
            if(arr[i]>0){
                break;
            }

            int num = arr[i];
            int left = i+1;
            int right = N-1;
            while(left < right){
                int sum = num+ arr[left] + arr[right];
                if(sum ==0){
                    int l = 1;
                    int r = 1;
                    if(arr[left] == arr[right]){
                        int n = right - left + 1;
                        cnt += combin(n);
                        break;
                    }
                    while(arr[left] == arr[left+1]){
                        l++;
                        left++;
                    }
                    while(arr[right] == arr[right-1]){
                        r++;
                        right--;
                    }

                    cnt+= l*r;
                }
                if(sum>0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static long combin(int n) {
        return n*(n-1)/2;
    }
}