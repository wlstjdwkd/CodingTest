import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<R && 0<=y && y<C;
//    }

    public static void main(String[] args) throws IOException {
        String s = null;
        while((s= br.readLine())!=null){
            int size =stoi(s) * 10000000;
            int N = stoi(br.readLine());
            int[] list = new int[N];
            for(int i=0;i<N;i++){
                list[i] = stoi(br.readLine());
            }

            Arrays.sort(list);

            int left = 0; int right = N-1;
            boolean flag = false;

            while(left<right){
                int sum = list[left] + list[right];

                if(sum == size){
                    System.out.println("yes "+list[left]+" "+list[right]);
                    flag = true;
                    break;
                }
                else if(sum > size){
                    right--;
                }
                else{
                    left++;
                }
            }

            if(!flag){
                System.out.println("danger");
            }

            s = null;
        }
    }


}