import java.io.*;

public class daily3_2사과나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i =0; i<n; i++) {
            String str[] = br.readLine().split("");
            for(int j =0; j<str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int maxS=0;
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum+=arr[i][j];
                if(0<i){
                    sum+=arr[i-1][j];
                }
                if(0<j){
                    sum+=arr[i][j-1];
                }
                if(i<n-1){
                    sum+=arr[i+1][j];
                }
                if(j<n-1){
                    sum+=arr[i][j+1];
                }
                maxS= Math.max(sum,maxS);
                sum=0;
            }
        }
        System.out.println(maxS);
    }
}