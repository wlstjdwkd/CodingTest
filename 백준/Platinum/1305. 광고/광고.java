import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int L;
    static String s;
    public static void main(String[] args) throws IOException {
        L =Integer.parseInt(br.readLine());
        s= br.readLine();
        System.out.println(L-KMP(s));

    }
    private static int KMP(String str){
        int len = str.length();
        int[] pi = new int[len];
        int j=0;
        for(int i=1;i<len; i++){
            while(j>0&&str.charAt(i)!=str.charAt(j)){
                j=pi[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                pi[i] = ++j;
            }
        }
        return pi[len-1];
    }
}