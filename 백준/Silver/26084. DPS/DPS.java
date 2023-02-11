import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String S;
    static int N;
    static long cnt = 1;
    static char[] handle;
    static boolean[] visit;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        N = Integer.parseInt(br.readLine());
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        S = new String(chars);


        long[] dps = new long[26];
        long[] ddps = new long[26];

//        System.out.println(S.charAt(0)-'A');
        for (int i = 0; i < 3; i++) {
            dps[S.charAt(i) - 'A']++;
        }
        for (int i = 0; i < N; i++) {
            ddps[br.readLine().charAt(0) - 'A']++;
        }
        for (int i = 0; i < dps.length; i++) {
            if (dps[i] == 0) {
                continue;
            }


            cnt *= combination(ddps[i], dps[i]);
        }

        System.out.println(cnt);
    }
    //            char c = chrArr[i];
//            int mapc= map.get(c);
//            int map2c = map2.get(c);
////            if(map2c ==1){
////                cnt*=mapc;
////            }
//            if(map2c==1){
//                cnt*=mapc;
//            }
//            else if(map2c==mapc){
//                continue;
//            }
//            else{
//                cnt*=combination(mapc,map2c);
//            }
//        Map<Character,Integer> map2 = new HashMap<>();
//        char[] chrArr = new char[3];
//        for(int i=0; i<3; i++){
//            chrArr[i]= S.charAt(i);
//
//            map2.put(chrArr[i],1);
//
//        }

//        handle = new char[N];
//        for(int i=0; i<N; i++){
//            char k = br.readLine().charAt(0);
//            if(map2.containsKey(k)){
//                handle[i] = br.readLine().charAt(0);
//            }
//            else{
//                continue;
//            }
//        }


//        Arrays.sort(handle);
//        visit = new boolean[N];
//        arr = new String[S.length()]; //3 고정
//
//        dfs(0,0);
//        System.out.println(cnt);
//        Map<Character,Integer> map2 = new HashMap<>();
//        char[] chrArr = new char[3];
//        for(int i=0; i<3; i++){
//            chrArr[i]= S.charAt(i);
//            if(map2.containsKey(chrArr[i])){
//                map2.put(chrArr[i],map2.get(chrArr[i])+1);
//            }
//            else{
//                map2.put(chrArr[i],1);
//            }
//        }
//
//
//
//        Map<Character,Integer> map = new HashMap<>();
//        for(int i=0; i<N; i++){
//            char a = br.readLine().charAt(0);
//            if(!map2.containsKey(a)){
//                continue;
//            }
//            if(map.containsKey(a)){
//                map.put(a,map.get(a)+1);
//            }
//            else{
//                map.put(a,1);
//            }
//        }

    //        for(int i=0; i<map2.size(); i++){
//            char c = chrArr[i];
//            int mapc= map.get(c);
//            int map2c = map2.get(c);
////            if(map2c ==1){
////                cnt*=mapc;
////            }
//            if(map2c==1){
//                cnt*=mapc;
//            }
//            else if(map2c==mapc){
//                continue;
//            }
//            else{
//                cnt*=combination(mapc,map2c);
//            }
//        }
//        sb.append(cnt);
//        System.out.println(sb);
//    }
    private static long combination(long n, long r) {
        if (r == 1) {
            return n;
        } else if (r == 2) {
            return (n * (n - 1)) / 2;
        } else {
            return (n * (n - 1) * (n - 2)) / 6;
        }
    }
}

//    private static void dfs(int depth, int start){
//        if(depth == 3){
//
//            sb = new StringBuilder();
//            for(int k=0; k<3; k++){
//                sb.append(arr[k]);
//            }
//            if(sb.toString().equals(S)){
//                cnt++;
//            }
//            return;
//        }
//        for(int i=start; i<N; i++){
//            if(!visit[i]){
//                visit[i]=true;
//                arr[depth]=Character.toString(handle[i]);
//                dfs(depth+1,i);
//                visit[i]=false;
//            }
//        }
//    }

