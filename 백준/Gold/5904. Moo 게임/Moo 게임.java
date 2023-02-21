import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    public static char result;
    static int N;
    public static void main(String[] args) throws IOException {
        N= Integer.parseInt(br.readLine());
        moo(N);
        System.out.println(result);
    }
    private static void moo(int num){
        int size = 3;
        int index=0;
        if(num==1){
            result='m';
        }
        else if(num<=3){
            result = 'o';
        }
        else{
            while(size<num){
                size = size*2+index+4;
                index++;
            }

            int prev_size = (size-index-3)/2;

            if(prev_size+1==num){
                result = 'm';
            }
            else if(size-prev_size+1<=num){
                moo(num-(size-prev_size));
            }
            else{
                result='o';
            }
        }
    }
}