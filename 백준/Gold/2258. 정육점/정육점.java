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
        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        Meat[] arr = new Meat[n];

        int total = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = stoi(st.nextToken());
            int price = stoi(st.nextToken());
            arr[i] = new Meat(weight, price);
            total += weight;
        }

        if(total < m){
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr);

        int weightSum =0;
        int priceSum = 0;
        int bPrice = 0;
        int min = Integer.MAX_VALUE;
        for(Meat cur : arr){
            weightSum += cur.weight;
            if(bPrice != cur.price){
                priceSum = bPrice = cur.price;
            }
            else{
                priceSum += cur.price;
            }


            if(weightSum >= m){
                min = Math.min(min, priceSum);
            }
        }

        System.out.println(min);
    }

    private static class Meat implements Comparable<Meat>{
        int weight;
        int price;
        public Meat(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Meat o) {
            if(this.price == o.price){
                return o.weight - this.weight;
            }
            return this.price - o.price;
        }
    }

}