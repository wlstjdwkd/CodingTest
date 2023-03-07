import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num3040백설공주와일곱난쟁이 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int[] input = new int[9];
        int fake1=0;
        int fake2=0;
        int sum=0;
        for(int i=0; i<9; i++){
            input[i]= Integer.parseInt(br.readLine());
            sum+=input[i];
        }

        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(input[i]+input[j]==sum-100){
                    fake1=i;
                    fake2=j;
                    break;
                }
            }
        }
        for(int i=0; i<9; i++){
            if(i==fake1|| i==fake2){
                continue;
            }
            sb.append(input[i]).append("\n");
        }
        System.out.println(sb);
    }
}
