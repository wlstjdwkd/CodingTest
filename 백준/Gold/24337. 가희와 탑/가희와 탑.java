import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static ArrayList<Integer> tower = new ArrayList<>();
    static int n,a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        a = Integer.valueOf(st.nextToken());
        b = Integer.valueOf(st.nextToken());

        if(a+b>n+1){
            System.out.println(-1);
            return;
        }

        for(int i=1; i<a; i++){
            tower.add(i);
        }
        tower.add(Math.max(a,b));

        for(int i=b-1; i >=1; i--){
            tower.add(i);
        }
        if(a==1){
            while(tower.size()<n){
                tower.add(1,1);
            }
        }
        else{
            while(tower.size()<n){
                tower.add(0,1);
            }
        }

        for(int i : tower){
            System.out.print(i+" ");
        }

    }
}