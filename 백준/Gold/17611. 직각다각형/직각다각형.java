import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] sum = new int[1000001][2];
        int x = Integer.parseInt(st.nextToken()) + 500000;
        int y = Integer.parseInt(st.nextToken()) + 500000;
        int startX = x;
        int startY = y;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken()) + 500000;
            int curY = Integer.parseInt(st.nextToken()) + 500000;
            if(x == curX){
                yLineSearch(sum, y, curY);
            }else{	//수평 선분일 때
                xLineSearch(sum, x, curX);
            }
            //이전 꼭지점 변경
            x = curX;
            y = curY;
        }

        //마지막 꼭지점과 첫 번째 곡지점 연결
        if(x == startX) {
            yLineSearch(sum, y, startY);
        }else{
            xLineSearch(sum, x, startX);
        }
        int result = 0;
        //최대값 탐색
        for(int i=0;i<1000001;i++){
            result = Math.max(result, Math.max(sum[i][0], sum[i][1]));
        }
        System.out.println(result);
    }

    static void xLineSearch(int[][] sum, int x, int curX){
        if(x > curX){
            for(int j=curX; j<x; j++){
                sum[j][0]++;
            }
        }
        else{
            for(int j=x; j<curX; j++){
                sum[j][0]++;
            }
        }
    }
    //수평 선분일 때 누적합 진행하는 함수
    static void yLineSearch(int[][] sum, int y, int curY){
        if(y > curY){		//←
            for(int j=curY;j<y;j++){
                sum[j][1]++;
            }
        }else{		//→
            for(int j=y;j<curY;j++){
                sum[j][1]++;
            }
        }
    }
}