import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.*;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

//    private static class Point{
//        int x, y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<n && 0<=y && y<m;
//    }


    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int TE = stoi(st.nextToken());
            int TX = stoi(st.nextToken());

            map.put(TE, map.getOrDefault(TE, 0) + 1);
            map.put(TX, map.getOrDefault(TX, 0) - 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Comparator.comparingInt(o -> o));

        int sum = 0;
        int max = 0;
        int ans_start = 0;
        int ans_end = 0;

        boolean opened = false;

        for(int key : keyList){
            sum += map.get(key);

            if(sum > max){
                max = sum;
                ans_start = key;
                opened = true;
            }
            else if( sum<max && opened){
                ans_end =key;
                opened = false;
            }
        }

        System.out.println(max);
        System.out.println(ans_start+ " " + ans_end);
    }


}