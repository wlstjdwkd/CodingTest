import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> nn = new ArrayList<>();
    static List<Integer> pn = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                pn.add(num);
            }
            else{
                nn.add(num);
            }
        }

        Collections.sort(pn, Collections.reverseOrder());
        Collections.sort(nn);
        int sum = 0;
        int i = 0;
        while(i < pn.size()){
            if(i+1 < pn.size() && pn.get(i) != 1 && pn.get(i+1) != 1){
                sum += pn.get(i) * pn.get(i+1);
                i += 2;
            }
            else{
                sum += pn.get(i);
                i++;
            }
        }

        i=0;

        while(i < nn.size()){
            if( i+1 < nn.size()){
                sum += nn.get(i) * nn.get(i+1);
                i += 2;
            }
            else{
                sum += nn.get(i);
                i++;
            }
        }

        System.out.println(sum);
    }
}