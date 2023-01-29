import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1932정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[][] nums = new int[a][];
        for(int i =0; i< a; i++){
            nums[i] = new int[i+1];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            for(int j=0; j<=i; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        for(int i=a-1; i>0; i--){
            for(int j=0; j<i; j++){
                nums[i-1][j] += Math.max(nums[i][j], nums[i][j+1]);
            }
        }
        System.out.println(nums[0][0]);
    }
}
