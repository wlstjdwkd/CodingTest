import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] a_pizza = new int[a];
        int max_a = 0;
        for(int i=0; i<a; i++){
            a_pizza[i] = Integer.parseInt(br.readLine());
            max_a += a_pizza[i];
        }

        int[] b_pizza = new int[b];
        int max_b = 0;
        for(int i=0; i<b; i++){
            b_pizza[i] = Integer.parseInt(br.readLine());
            max_b += b_pizza[i];
        }

        int[] a_count = new int[Math.max(max_a, size)+1];
        a_count[0] = 1;
        a_count[max_a] = 1;
        count(a_pizza, a_count, size);

        int[] b_count = new int[Math.max(max_b, size)+1];
        b_count[0] = 1;
        b_count[max_b] = 1;
        count(b_pizza, b_count, size);

        int result = 0;
        for(int i=0; i<=size; i++){
            result += a_count[i]*b_count[size-i];
        }
        System.out.println(result);
    }
    private static void count(int[] pizza, int[] count, int size){
        for(int i=0; i<pizza.length; i++){//시작점
            int sum = 0;
            for(int j=1; j<pizza.length; j++){//선택 갯수
                int sum_j = pizza[(i+j)%pizza.length];
                if(sum+sum_j>size){
                    break;
                }
                sum += sum_j;
                count[sum]++;
            }
        }
    }
}