import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] size = new int[M][M];
        for(int i=0; i<M; i++){
            Arrays.fill(size[i], 1);
        }

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            for(int i= M-1; i>0; i--){
                if(zero > 0){
                    zero--;
                }
                else if(one > 0){
                    size[i][0]++;
                    one--;
                }
                else if(two > 0){
                    size[i][0] += 2;
                    two--;
                }
            }

            for(int i=0; i<M; i++){
                if(zero > 0){
                    zero--;
                }
                else if(one > 0){
                    size[0][i]++;
                    one--;
                }
                else if(two > 0){
                    size[0][i] += 2;
                    two--;
                }
            }
        }

        for(int i=1; i<M; i++){
            for(int j=1; j<M; j++){
                size[i][j]= Math.max(size[i-1][j], Math.max(size[i][j-1], size[i-1][j-1]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                sb.append(size[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}