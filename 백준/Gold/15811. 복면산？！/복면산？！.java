import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isArea(int x, int y){
        return 0<= x && x<5 && 0<=y && y<9;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        str1 = st.nextToken();
        str2 = st.nextToken();
        str3 = st.nextToken();
        if(distinct() > 10){
            System.out.println("NO");
        }
        else{
            abc = new int[26];
            Arrays.fill(abc, -1);
            int[] output = new int[set.size()];
            boolean[] visited = new boolean[10];
            permutation(output, visited, 0, set.size());
            if(result){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }

    }

    private static void verification(int[] output){
        Iterator<Character> iterator = set.iterator();
        for(int i=0; i<set.size(); i++){
            abc[iterator.next()-'A'] = output[i];
        }
        if(calc(str1) + calc(str2) == calc(str3)){
            result = true;
        }
    }

    private static void permutation(int[] output, boolean[] visited, int depth, int r){
//        if(!result){
            if(depth == r){
                verification(output);
                return;
            }
            for(int i=0; i<10; i++){
                if(!visited[i]){
                    visited[i] = true;
                    output[depth] = i;
                    permutation(output, visited, depth+1, r);
                    visited[i] = false;
                }
            }
//        }

    }

    private static int calc(String str){
        int sum = 0;
        int j= 1;
        for(int i=str.length()-1; i>=0; i--){
            sum += (abc[str.charAt(i) - 'A']*j);
            j*=10;
        }

        return sum;
    }

    private static int distinct(){
        set = new HashSet<>();
        for(int i=0; i<str1.length(); i++){
            set.add(str1.charAt(i));
        }
        for(int i=0; i<str2.length(); i++){
            set.add(str2.charAt(i));
        }
        for(int i=0; i<str3.length(); i++){
            set.add(str3.charAt(i));
        }
        return set.size();
    }

    private static String str1, str2, str3;
    private static int[] abc;
    private static Set<Character> set;
    private static boolean result;


}