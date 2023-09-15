import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> result = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        char[] alpha = new char[N];
        for(int i=0; i<N; i++){
            String word = br.readLine();
            alpha[i] = word.charAt(0);
        }
        int start=0; int end = N-1;
        for(int i=0; i<N; i++){
            if((int)alpha[start] < (int)alpha[end]){
                result.add(alpha[start++]);
            }
            else if((int)alpha[start]==(int)alpha[end]){
                int front = start, back = end;
                boolean check=true;
                while(alpha[front]==alpha[back]){
                    if(back>0){
                        back--;
                    }
                    if(front<N-1){
                        front++;
                    }
                    if((int)alpha[front]<(int)alpha[back]){
                        check=true;
                        break;
                    }
                    else if((int)alpha[front]>(int)alpha[back]){
                        check = false;
                        break;
                    }
                }
                if(check) result.add(alpha[start++]);
                else result.add(alpha[end--]);
            }
            else{
                result.add(alpha[end--]);
            }
        }

        for(int i=0; i<result.size(); i++){
            if(i!=0 && i%80==0){
                sb.append("\n");
            }
            sb.append(result.get(i));
        }
        System.out.println(sb.toString());
    }
}