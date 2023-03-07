import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class num1946신입사원 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int cnt=1;
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for(int j=0; j<N; j++){
                st= new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int min = arr[0][1];
            for(int j=1; j<N; j++){
                if(arr[j][1]<min){
                    min = arr[j][1];
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}