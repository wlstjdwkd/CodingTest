import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static int P,S;
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
//    static String dna;
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine());
//        P = Integer.parseInt(st.nextToken());
//        S = Integer.parseInt(st.nextToken());
//        dna = br.readLine();
//
//
//        st = new StringTokenizer(br.readLine());
//        int[] ACGT = new int[4];
//        for(int i=0; i<4; i++){
//            ACGT[i] = Integer.parseInt(st.nextToken());
//        }
//        int cnt=0;
////        sb.append(dna);
//        for(int i=0; i<dna.length()-S+1; i++){
//            if(countChar(sb.substring(i,i+S),'A')>=ACGT[0] &&
//                countChar(sb.substring(i,i+S),'C')>=ACGT[1] &&
//                    countChar(sb.substring(i,i+S),'G')>=ACGT[2] &&
//                        countChar(dna.substring(i,i+S),'T')>=ACGT[3]){
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
//    }
//    public static long countChar(String str, char ch){
//        return str.chars()
//                .filter(c -> c == ch)
//                .count();
//    }
static int p,s;
    static int answer=0;
    static int a,c,g,t;
    public static boolean check(HashMap<Character,Integer> hm) {

        Set<Character> key = hm.keySet();
        for(Iterator it = key.iterator(); it.hasNext();) {

            Character keyValue = (Character)it.next();
            if(keyValue=='A' && hm.get(keyValue)<a) {return false;}
            else if(keyValue=='C' && hm.get(keyValue)<c) {return false;}
            else if(keyValue=='G' && hm.get(keyValue)<g) {return false;}
            else if(keyValue=='T' && hm.get(keyValue)<t) {return false;}

        }

        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p =Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        HashMap<Character,Integer>hm = new HashMap<>();
        String str = br.readLine();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        a = n;
        hm.put('A', 0);
        n = Integer.parseInt(st.nextToken());
        c = n;
        hm.put('C', 0);
        n = Integer.parseInt(st.nextToken());
        g = n;
        hm.put('G', 0);
        n = Integer.parseInt(st.nextToken());
        t = n;
        hm.put('T', 0);

        for(int i=0; i<s; i++) {

            char cc = str.charAt(i);
            hm.put(cc, hm.get(cc)+1);
        }

        if(check(hm))answer++;

        for(int i=1; i+s-1<p; i++) {

            char prevc = str.charAt(i-1);
            char nextc = str.charAt(i+s-1);
            hm.put(prevc, hm.get(prevc)-1);
            hm.put(nextc, hm.get(nextc)+1);

            if(check(hm))answer++;

        }


        System.out.println(answer);

    }
}
