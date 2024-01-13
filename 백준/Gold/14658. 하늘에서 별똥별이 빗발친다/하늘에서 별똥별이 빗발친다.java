import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, L, K;
    static List<int[]> stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        L= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();

        for(int i=0;i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x,y});
        }
        int res = Integer.MIN_VALUE;
        for(int[] s1: stars){
            for(int[] s2: stars){
                res = Math.max(res,boundStar(s1[0],s2[1]));
            }
        }
//        for(int[] s1 : stars){
//            res = Math.max(res,boundStar(s1[0]-L,s1[1]-L));
//            res = Math.max(res,boundStar(s1[0]-L,s1[1]));
//            res = Math.max(res,boundStar(s1[0],s1[1]));
//            res = Math.max(res,boundStar(s1[0],s1[1]-L));
//        }
        System.out.println(K-res);
    }

    public static int boundStar(int i, int j){
        int res = 0;
        for(int[] s: stars){
            if(s[0]>=i && s[0]<=i+L && s[1]>=j && s[1]<=j+L){
                res++;
            }
        }
        return res;
    }
}