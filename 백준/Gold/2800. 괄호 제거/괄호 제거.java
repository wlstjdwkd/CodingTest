import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Pair> pairs;
    static int pairCount;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        Stack<Integer> stk = new Stack<>();
        pairs = new ArrayList<>();
        set = new TreeSet<>();

        for(int i=0; i<len; i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stk.add(i);
            }
            else if (cur ==')'){
                pairs.add(new Pair(stk.pop(),i));
            }
        }

        pairCount = pairs.size();
        makeString(0,s);

        set.remove(s);

        StringBuilder sb = new StringBuilder();
        for (String s1 : set) {
            sb.append(s1).append("\n");
        }
        System.out.println(sb);

    }

    static void makeString(int idx, String str){
        if(idx == pairCount){
            set.add(str.replace(" ",""));
            return;
        }
        Pair pair = pairs.get(idx);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(pair.left,' ');
        sb.setCharAt(pair.right,' ');
        //제거 한거
        makeString(idx+1,sb.toString());
        //제거 안한거
        makeString(idx+1,str);

    }

    static class Pair{
        int left, right;
        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}