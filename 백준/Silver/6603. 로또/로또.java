import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] input;
    static boolean[] visit;
    static int[] arr;
    static int k;
    public static void main(String[] args) throws IOException {
        while(true){
            st=new StringTokenizer(br.readLine());
            k =Integer.parseInt(st.nextToken());
            if(k==0){
                break;
            }
            else{
                input = new int[k];
                visit = new boolean[k];
                for(int i=0; i<k; i++){
                    input[i] = Integer.parseInt(st.nextToken());
                }
                combi(0,0);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void combi(int start, int depth){
        if(depth==6){
            for(int i=0; i<k; i++){
                if(visit[i]){
                    sb.append(input[i]).append(" ");

                }
            }
            sb.append("\n");
        }
        for(int i=start; i<k; i++){
            visit[i]=true;
            combi(i+1,depth+1);
            visit[i]=false;
        }
    }
}
