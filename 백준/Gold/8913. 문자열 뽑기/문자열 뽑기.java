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
        int N = stoi(br.readLine());
        for(int i=0; i<N; i++){
            isSuccess = false;
            String s = br.readLine();
            dfs(s);
            if(isSuccess){
                sb.append("1\n");
            }
            else{
                sb.append("0\n");
            }
        }
        System.out.println(sb.toString());
    }

    static boolean isSuccess;

    private static void dfs(String str){
        if(isSuccess){
            return;
        }

        int cont = 1;
        int stidx = 0;

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1) == str.charAt(i)){
                cont++;
            }
            else{
                if(cont>=2){
                    dfs(str.substring(0, stidx) + str.substring(stidx + cont));
                }
                stidx = i;
                cont = 1;
            }
        }

        if(str.length() >= 2 && str.length() == cont){
            isSuccess = true;
            return;
        }
    }

}