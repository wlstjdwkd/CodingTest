import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

//    private static boolean isArea(int x, int y){
//        return 1<=x && x<=m && 1<=y && y<=n;
//    }

    private static int L,C;
    private static char[] list;
    private static char[] code;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        L = stoi(st.nextToken());
        C = stoi(st.nextToken());

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<C; i++){
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);

        makeCode(0,0);
    }

    private static void makeCode(int x, int idx){
        if(idx == L){
            if(isValid()){
                System.out.println(code);
            }
            return;
        }

        for(int i=x; i<C; i++){
            code[idx] = list[i];
            makeCode(i+1, idx+1);
        }
    }

    private static boolean isValid(){
        int mo = 0;
        int ja = 0;
        for(final char x : code){
            if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
                mo++;
            }
            else{
                ja++;
            }
        }

        if(mo >= 1 && ja >= 2){
            return true;
        }

        return false;
    }



}