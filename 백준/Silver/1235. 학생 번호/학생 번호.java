import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i]=br.readLine();
        }
        for(int i=arr[0].length()-1; i>=0; i--){
            List<String> list = new ArrayList<>();

            for(int j=0; j<N; j++){
                String k = arr[j].substring(i,arr[0].length());
                if (!list.contains(k)) {
                    list.add(k);
                }
                else{
                    break;
                }

            }
            if(N==list.size()){
                System.out.println(arr[0].length()-i);
                return;
            }

        }
    }
}
