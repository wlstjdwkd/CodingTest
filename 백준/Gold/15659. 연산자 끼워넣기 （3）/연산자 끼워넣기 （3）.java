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
        N = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        cmdcount = new int[4];
        for(int i=0; i<N; i++){
            arr[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            cmdcount[i] = stoi(st.nextToken());
        }
        combine(0, new int[N-1], cmdcount[0], cmdcount[1], cmdcount[2], cmdcount[3]);

        System.out.println(maxAns);
        System.out.println(minAns);

    }

    private static void combine(int depth, int[] cmdArr, int plusCount, int minusCount, int multiCount, int divCount){
        if(depth == N-1){
            calc(cmdArr);
            return;
        }

        if(plusCount > 0){
            cmdArr[depth] =0;
            combine(depth+1, cmdArr, plusCount-1, minusCount, multiCount, divCount);
        }

        if(minusCount > 0){
            cmdArr[depth] =1;
            combine(depth+1, cmdArr, plusCount, minusCount-1, multiCount, divCount);
        }

        if(multiCount > 0){
            cmdArr[depth] =2;
            combine(depth+1, cmdArr, plusCount, minusCount, multiCount-1, divCount);
        }

        if(divCount > 0){
            cmdArr[depth] =3;
            combine(depth+1, cmdArr, plusCount, minusCount, multiCount, divCount-1);
        }
    }

    private static void calc(int[] cmdArr){
        List<Integer> cmdList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        numList.add(arr[0]);
        for(int i=0; i<cmdArr.length; i++){
            switch(cmdArr[i]){
                case 0:
                case 1:
                    numList.add(arr[i+1]);
                    cmdList.add(cmdArr[i]);
                    break;
                case 2:
                    numList.add(numList.remove(numList.size()-1) * arr[i+1]);
                    break;
                case 3:
                    numList.add(numList.remove(numList.size()-1) / arr[i+1]);
                    break;
            }
        }

        int ret = numList.get(0);
        if(!cmdList.isEmpty()){
            for(int i=0; i<cmdList.size(); i++){
                int cmd = cmdList.get(i);
                if(cmd == 0){
                    ret += numList.get(i+1);
                }
                else{
                    ret -= numList.get(i+1);
                }
            }
        }

        maxAns = Math.max(maxAns, ret);
        minAns = Math.min(minAns, ret);

    }

    private static int N;
    private static int[] arr;
    private static int[] cmdcount;
    private static int maxAns = Integer.MIN_VALUE, minAns = Integer.MAX_VALUE;


}