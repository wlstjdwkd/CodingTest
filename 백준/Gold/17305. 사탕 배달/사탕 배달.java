import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(m<3){
            System.out.println(0);
        }
        else{
            List<Integer> three = new ArrayList<>();
            List<Integer> five = new ArrayList<>();

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int t = stoi(st.nextToken());
                int s = stoi(st.nextToken());
                if(t==3){
                    three.add(s);
                }
                else{
                    five.add(s);
                }
            }

            Collections.sort(three, Collections.reverseOrder());
            Collections.sort(five, Collections.reverseOrder());

            long[] threeSum = new long[three.size() + 1];
            long[] fiveSum = new long[five.size() + 1];

            for (int i = 1; i <= three.size(); i++)
                threeSum[i] = three.get(i-1) + threeSum[i - 1];

            //5g 누적합 구하기
            for (int i = 1; i <= five.size(); i++)
                fiveSum[i] = five.get(i-1) + fiveSum[i - 1];

            int t_index = Math.min(three.size(), m/3);
            long sum = 0;
            int fiveSize = five.size();

            while(t_index>=0){
                int f_index = Math.min((m - 3*t_index)/5, fiveSize);
                long temp = threeSum[t_index] + fiveSum[f_index];

                sum = Math.max(sum,temp);
                t_index--;
            }

            System.out.println(sum);

        }
    }
}