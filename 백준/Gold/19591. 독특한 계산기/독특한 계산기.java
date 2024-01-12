import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Long> number;
    static ArrayList<Character> operator;
    static long start, finish;
    static int startIdx, finishIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        number = new ArrayList<>();
        operator = new ArrayList<>();
        String s =br.readLine();
        long value = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                //연산자
                number.add(value);
                operator.add(s.charAt(i));
                value = 0;
            }
            else{
                //숫자
                if(value == 0 && s.charAt(i) != '0'){
                    value = s.charAt(i) - '0';
                }
                else if(value != 0){
                    //숫자앞에 불필요한 0이 나올 수도 있음

                    //연속으로 숫자가 나와버렸음
                    //이전꺼 10배하고 더하기
                    value *= 10;
                    value += s.charAt(i) - '0';
                }
            }
        }
        number.add(value);
        if(number.get(0) == 0 && !operator.isEmpty()){
            //처음 음수
            //이러면 startIdx가 0은 첫음수 -니까 1로 변경해줘야함
            startIdx = 1;
            start = number.get(1) * -1;
        }
        else{
            start = number.get(0);
        }

        finishIdx = operator.size()-1;
        finish = number.get(number.size()-1);
        long result = 0;
        if(operator.size()==0 || (operator.size() == 1 && number.get(0) == 0)){
            //숫자 하나밖에 없는 경우
            result = start;
        }
        else{
            while(startIdx!=finishIdx){
                char first = operator.get(startIdx);
                char last = operator.get(finishIdx);
                if((first == '-' || first == '+' ) && (last == '*' || last == '/')){
                    long next = number.get(finishIdx);
                    finish = cal(next, finish, last);
                    finishIdx--;
                } else if ((first == '*' || first == '/') && (last == '-' || last == '+')) {
                    long next = number.get(startIdx + 1);
                    start = cal(start,  next, operator.get(startIdx));
                    startIdx++;
                }
                else{
                    long next1 = number.get(startIdx+1);
                    long start2 = cal(start, next1, operator.get(startIdx));
                    long next2 = number.get(finishIdx);
                    long finish2 = cal(next2, finish, operator.get(finishIdx));
                    if(start2 < finish2){
                        finish = finish2;
                        finishIdx--;
                    }
                    else{
                        start = start2;
                        startIdx++;
                    }

                }
            }
            result = cal(start, finish, operator.get(startIdx));

        }

        System.out.println(result);

    }

    private static long cal(long next, long finish2, char character){
        if(character == '+'){
            return next + finish2;
        }
        else if(character == '-'){
            return next - finish2;
        }
        else if(character == '*'){
            return next * finish2;
        }
        else{
            return next / finish2;
        }
    }
}