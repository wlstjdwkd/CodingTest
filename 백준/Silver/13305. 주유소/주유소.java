import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] distance;
    static int[] station;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        distance = new int[N-1];
        station = new int[N-1];
        int sum=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            distance[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        station[0]= Integer.parseInt(st.nextToken());
        for(int i=1; i<N-1; i++){
            int newStation = Integer.parseInt(st.nextToken());
            if(newStation>station[i-1]){
                station[i] = station[i-1];
            }
            else{
                station[i] = newStation;
            }
        }
        st.nextToken();
        for(int i=0; i<N-1; i++){
            sum+=(station[i]*distance[i]);
        }
        System.out.println(sum);

    }
}
