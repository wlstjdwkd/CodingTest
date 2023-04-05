import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,d,k,c, arr[], visited[];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new int[d+1];

        System.out.println(slide());
    }
    private static int slide(){
        int inSlide=0, chance;
        for(int i=0; i<k; i++){
            if(visited[arr[i]]==0){
                inSlide++;
            }
            visited[arr[i]]++;
        }

        chance=inSlide;
        for(int i=1; i<N; i++){
            if(chance<=inSlide){
                if(visited[c]==0){
                    chance = inSlide+1;
                }
                else{
                    chance = inSlide;
                }
            }
            visited[arr[i-1]]--;
            if(visited[arr[i-1]]==0){
                inSlide--;
            }

            if(visited[arr[(i+k-1) % N]] ==0){
                inSlide++;
            }
            visited[arr[(i+k-1) % N]]++;
        }
        return chance;

    }
}