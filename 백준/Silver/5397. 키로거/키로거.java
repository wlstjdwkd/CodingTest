import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++){
            String str= br.readLine();
            char[] chrArr = str.toCharArray();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for(int j=0; j<chrArr.length; j++){
                switch(chrArr[j]){
                    case '<':
                        if(iter.hasPrevious()){
                            iter.previous();
                        }
                        break;
                    case '>':
                        if(iter.hasNext()){
                            iter.next();
                        }
                        break;
                    case '-':
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(chrArr[j]);
                        break;
                }
            }
            for(char k : list){
                sb.append(k);
            }
            sb.append('\n');

        }
        System.out.println(sb);
    }
}
