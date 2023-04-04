import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cnt=0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();

        KMP(str1,str2);
        System.out.println(cnt);
        System.out.println(sb);

    }
    private static int[] getPi(String pattern){
        int[] pi = new int[pattern.length()];
        int j=0;
        //전체 문자열 돌기
        for(int i=1; i<pattern.length(); i++){
            while(j>0 && pattern.charAt(i) != pattern.charAt(j)){
                j= pi[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                pi[i] = ++j;
            }
        }

        return pi;
    }
    private static void KMP(String str, String pattern){
        int[] pi = getPi(pattern);
        int j=0;
        for(int i=0; i<str.length(); i++){
            while(j>0 && str.charAt(i)!= pattern.charAt(j)){
                j=pi[j-1];
            }
            if(str.charAt(i)== pattern.charAt(j)){
                if(j==pattern.length()-1){
                    ++cnt;
                    sb.append(i-j+1).append("\n");

                    j=pi[j];
                }
                else{
                    j++;
                }
            }
        }
    }

}