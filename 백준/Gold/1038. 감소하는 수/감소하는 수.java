import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Long> list;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        if(N<=10){
            System.out.println(N);
        }
        else if(N>1022){
            System.out.println(-1);
        }
        else{
            for(int i=0; i<10; i++){
                dfs(i,0);
            }
            Collections.sort(list);

            System.out.println(list.get(N));
        }
    }
    private static void dfs(long num, int depth){


        list.add(num);
        for(int i=0; i<num%10; i++){
            dfs((num * 10)+i, depth+1);
        }
    }
}
