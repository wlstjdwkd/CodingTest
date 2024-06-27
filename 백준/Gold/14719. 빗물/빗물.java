import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int h = stoi(st.nextToken());
        int w = stoi(st.nextToken());

        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            height[i] = stoi(st.nextToken());
        }

        int result = 0;
        for(int i=1; i< w-1; i++){
            int left = 0;
            int right = 0;

            for(int j=0; j<i; j++){
                left = Math.max(left, height[j]);
            }

            for(int j=i+1; j<w; j++){
                right = Math.max(right, height[j]);
            }

            if(height[i] < left && height[i] < right){
                result += Math.min(left, right) - height[i];
            }
        }

        System.out.println(result);
    }
}