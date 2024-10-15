import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static char[] split;
    private static int value;

    private static long answer;

    private static String input;

    private static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        input = st.nextToken();

        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');


        answer = 0;

        backTracking(input.contains("L"),1,1,0,0,0,input);

        System.out.println(answer);
    }

    private static void backTracking(boolean haveL, long vowelLine, long consonantLine, int idx, int vowelCnt, int consonantCnt, String input){
        if(vowelCnt == 3 || consonantCnt == 3){
            return;
        }
        if(idx == input.length()){
            if(!haveL){
                return;
            }

            answer += vowelLine * consonantLine;
            return;
        }

        char ch = input.charAt(idx);

        if(ch=='_'){
            //모음
            backTracking(haveL, vowelLine*5,consonantLine, idx+1, vowelCnt + 1, 0, input);

            //L제외 자음
            backTracking(haveL, vowelLine, consonantLine*20, idx+1, 0, consonantCnt+1, input);

            //L
            backTracking(true, vowelLine, consonantLine, idx+1, 0, consonantCnt+1, input);
        }
        else{
            if(set.contains(ch)){
                //모음이면
                backTracking(haveL, vowelLine, consonantLine, idx+1, vowelCnt + 1, 0, input);
            }
            else{
                backTracking(haveL, vowelLine, consonantLine, idx+1, 0, consonantCnt+1, input);
            }
        }


    }

}