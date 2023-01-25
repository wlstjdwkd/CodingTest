import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class daily3_3빌딩건설 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            int s = Integer.parseInt(br.readLine());
            String [][] arr = new String[s][s];
            for(int j=0; j<s; j++){
                String str[] = br.readLine().split(" ");
                for(int k=0; k<str.length; k++){
                    arr[j][k] = str[k];
                }
            }
            int maxS=0;
            for(int j=0; j<s; j++){
                for(int k=0; k<s; k++){
                    int sum=0;
                    if(arr[j][k].equals('B')){
                        if(0<j){
                            if(arr[j-1][k].equals('G')) {
                                continue;
                            }
                        }
                        if(0<k){
                            if(arr[j][k-1].equals('G')){
                                continue;
                            }
                        }
                        if(j<s-1){
                            if(arr[j+1][k].equals('G')){
                                continue;
                            }
                        }
                        if(k<s-1){
                            if(arr[j][k+1].equals('G')){
                                continue;
                            }
                        }
                        if(arr[j-1][k-1].equals('G')||arr[j-1][k+1].equals('G')||arr[j+1][k-1].equals('G')||arr[j+1][k+1].equals('G')){
                            continue;
                        }
                        for(int t=0; t<n-1; t++){
                            if(arr[t][k].equals('B')){
                                sum+=1;
                            }
                        }
                        for(int t=0; t<n-1; t++){
                            if(arr[j][t].equals('B')){
                                sum+=1;
                            }
                        }
                        maxS= Math.max(sum,maxS);
                    }
                }
            }
            System.out.println("#"+i+1+" "+maxS);

        }
    }
}
