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
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int HAtk = stoi(st.nextToken());
        long start = 1, end = 0;

        Room rooms[] = new Room[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int t = stoi(st.nextToken());
            int a = stoi(st.nextToken());
            int h = stoi(st.nextToken());
            rooms[i]=new Room(t,a,h);
            if(t==1){
                end +=((long)a *h);
            }
        }

        while(start<=end){
            long mid =(start+end)/2;
            long HCurHp = mid;
            long tempHAtk = HAtk;
            boolean success = true;
            for(int i=0; i<N; i++){
                if(rooms[i].t == 1){
                    if(rooms[i].h % tempHAtk == 0){
                        HCurHp -= rooms[i].a * ((rooms[i].h/tempHAtk) - 1);
                    }
                    else{
                        HCurHp -= rooms[i].a * (rooms[i].h / tempHAtk);
                    }
                    if(HCurHp <=0){
                        success = false;
                        break;
                    }
                }
                else{
                    tempHAtk += rooms[i].a;
                    HCurHp += rooms[i].h;
                    if(HCurHp > mid){
                        HCurHp = mid;
                    }
                }
            }

            if(success){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(start);
        
    }

    private static class Room{
        int t,a,h;
        Room(int t, int a, int h){
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }


}