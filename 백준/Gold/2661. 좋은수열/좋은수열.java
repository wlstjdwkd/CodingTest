import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        backTracking("");
    }
    public static void backTracking(String result){
        if(result.length()==N){
            System.out.println(result);
            System.exit(0);
        }
        for(int i = 1; i <= 3; i++){
            if(isGood(result+i)){
                backTracking(result+i);
            }

        }
    }
    public static boolean isGood(String s){
        int length = s.length()/2;
        for(int i=1; i<=length; i++){
            if(s.substring(s.length()-i).equals(s.substring(s.length()-2*i, s.length()-i))){
                return false;
            }
        }
        return true;
    }
}