import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(!arr.contains(str)){
                arr.add(str);
            }
        }

        n = arr.size();

        int a = 0;
        int b = 0;
        int max = 0;

        for(int i=0; i<n-1; i++){
            String str1 = arr.get(i);
            for(int j=i+1; j<n; j++){
                String str2 = arr.get(j);
                int count = 0;
                int len = (str1.length()<str2.length()) ? str1.length() : str2.length();
                for(int k=0; k<len; k++){
                    if(str1.charAt(k) == str2.charAt(k)){
                        count++;
                    }
                    else{
                        break;
                    }
                }
                if(max < count){
                    max = count;
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(arr.get(a));
        System.out.println(arr.get(b));
    }
}