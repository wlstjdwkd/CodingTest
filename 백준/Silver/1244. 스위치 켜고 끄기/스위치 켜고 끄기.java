import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int temp=num;
            int start=0;
            int end=0;


            if(p==1){
                while(num<=n){
                    if(arr[num-1]==1){
                        arr[num-1]=0;
                    }
                    else{
                        arr[num-1]=1;
                    }
                    num+=temp;
                }
            }
            else{
                start=num-1;
                end=num-1;
                while(true){
                    if(start==0 || end == n-1){
                        break;
                    }
                    if(arr[start-1]==arr[end+1]){
                        start-=1;
                        end+=1;
                    }
                    else{
                        break;
                    }
                }
                for(int j=start; j<end+1; j++){
                    if(arr[j]==1){
                        arr[j]=0;
                    }
                    else{
                        arr[j]=1;
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            if(cnt==20){
                sb.append("\n");
                cnt=0;
            }
            sb.append(arr[i]).append(" ");
            cnt++;
        }

        System.out.println(sb.toString());

    }
}
