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
//        return 0<= x && x<n && 0<=y && y<m;
//    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = stoi(br.readLine());
        }

        int[] totalValuesSum = new int[(numbers.length * (numbers.length +1))/2];

        int count = 0;
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                totalValuesSum[count++] = numbers[i] + numbers[j];
            }
        }

        Arrays.sort(totalValuesSum);

        int answer = -1;
        for(int i=0; i< numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(binarySearch(totalValuesSum, numbers[i] - numbers[j])){
                    answer = Math.max(answer, numbers[i]);
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean binarySearch(int[] arr, int value){
        int l = 0;
        int r = arr.length - 1;

        while(l <= r){
            int mid = (l + r)/2;
            if(arr[mid] > value){
                r = mid - 1;
            }
            else if(arr[mid] < value){
                l = mid + 1;
            }
            else{
                return true;
            }
        }

        return false;
    }



}