import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        getPrime(n);

        int left = 0, right = 0, ans = 0, sum = 2;
        int size = prime.size();

        while(left<size && right < size){
            if(sum == n){
                ans++;
                sum -= prime.get(left);
                left++;
            }
            else if(sum > n){
                sum -= prime.get(left);
                left++;
            }
            else{
                right++;
                if(right<size){
                    sum += prime.get(right);
                }
            }
        }
        System.out.println(ans);
    }

    //에라토스테네스의 체
    //범위 소수 여러개 구하기
    static void getPrime(int n){
        int[] temp = new int[n+1];
        int rootN = (int)Math.sqrt(n);
        //먼저 2부터 n까지의 수를 배열에 넣는다.
        for(int i=2; i<=n; i++){
            temp[i]=i;
        }

        //2부터 시작해서 그의 배수들을 0으로 만든다.
        //제곱근까지만 해도됨
        for(int i=2; i<=rootN; i++){
            if(temp[i]==0){
                continue;
            }
            for(int j=i+i; j<=n; j+=i){
                temp[j]=0;
            }
        }

        for(int i=2; i<=n; i++){
            if(temp[i]!=0){
                prime.add(temp[i]);
            }
        }
    }
}