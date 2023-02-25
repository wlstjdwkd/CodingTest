import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] arr;
    static int[][] copyarr;
    static ArrayList<CCTV> list = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static class CCTV{
        int x;
        int y;
        int num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = st.nextToken().charAt(0)-'0';
                if(arr[i][j]!=0 && arr[i][j]!=6){
                    list.add(new CCTV(i,j,arr[i][j]));
                }
            }
        }
        dfs(0,arr);
        System.out.println(result);


    }
    private static void checkLeft(int[][] map, int x, int y){
        int a=y;
        while(true){
            if(a-1<0 || map[x][a-1]==6){
                break;
            }
            if(map[x][a-1]!=0){
                a--;
                continue;
            }
            map[x][a-1]=-1;
            a--;
        }
    }
    private static void checkRight(int[][] map, int x, int y){
        int a=y;
        while(true){
            if(a+1>=M || map[x][a+1]==6){
                break;
            }
            if(map[x][a+1]!=0){
                a++;
                continue;
            }
            map[x][a+1]=-1;
            a++;
        }
    }
    private static void checkUp(int[][] map, int x, int y){
        int a=x;
        while(true){
            if(a-1<0 || map[a-1][y]==6){
                break;
            }
            if(map[a-1][y]!=0){
                a--;
                continue;
            }
            map[a-1][y]=-1;
            a--;
        }
    }
    private static void checkDown(int[][]map, int x, int y){
        int a =x;
        while(true){
            if(a+1>=N || map[a+1][y]==6){
                break;
            }
            if(map[a+1][y]!=0){
                a++;
                continue;
            }
            map[a+1][y]=-1;
            a++;
        }
    }

    private static int[][] copyArr(int[][] temp){
        int[][]temp2 = new int[N][M];
        for(int i=0; i<N; i++){
            System.arraycopy(temp[i],0,temp2[i],0,M);
        }
        return temp2;
    }

    private static int getZero(int[][] temp){
        int zero=0;
        for(int i=0; i<N;i++){
            for(int j=0; j<M; j++){
                if(temp[i][j]==0){
                    zero++;
                }
            }
        }
        return zero;
    }
    private static void dfs(int cnt, int[][]map){
        if(cnt == list.size()){
            if(result>getZero(map)){
                result=getZero(map);

            }
            return;
        }
        int num = list.get(cnt).num;
        int x = list.get(cnt).x;
        int y = list.get(cnt).y;
        int[][] temp;
        switch(num){
            case 1:
                temp = copyArr(map);
                checkLeft(temp,x,y);
                dfs(cnt+1,temp);

                temp = copyArr(map);
                checkUp(temp,x,y);
                dfs(cnt+1,temp);

                temp=copyArr(map);
                checkRight(temp,x,y);
                dfs(cnt+1,temp);

                temp=copyArr(map);
                checkDown(temp,x,y);
                dfs(cnt+1,temp);
                break;
            case 2:
                temp = copyArr(map);
                checkLeft(temp,x,y);
                checkRight(temp,x,y);
                dfs(cnt+1,temp);

                temp = copyArr(map);
                checkUp(temp,x,y);
                checkDown(temp,x,y);
                dfs(cnt+1,temp);
                break;
            case 3:
                temp=copyArr(map);
                checkUp(temp,x,y);
                checkRight(temp,x,y);
                dfs(cnt+1,temp);

                temp= copyArr(map);
                checkUp(temp,x,y);
                checkLeft(temp,x,y);
                dfs(cnt+1,temp);

                temp=copyArr(map);
                checkLeft(temp,x,y);
                checkDown(temp,x,y);
                dfs(cnt+1,temp);

                temp=copyArr(map);
                checkDown(temp,x,y);
                checkRight(temp,x,y);
                dfs(cnt+1,temp);

                break;
            case 4:
                temp=copyArr(map);
                checkRight(temp,x,y);
                checkUp(temp,x,y);
                checkLeft(temp,x,y);
                dfs(cnt+1,temp);

                temp=copyArr(map);
                checkUp(temp,x,y);
                checkLeft(temp,x,y);
                checkDown(temp,x,y);
                dfs(cnt+1,temp);

                temp = copyArr(map);
                checkLeft(temp,x,y);
                checkDown(temp,x,y);
                checkRight(temp,x,y);
                dfs(cnt+1,temp);

                temp=copyArr(map);
                checkUp(temp,x,y);
                checkRight(temp,x,y);
                checkDown(temp,x,y);
                dfs(cnt+1,temp);
                break;
            case 5:
                temp=copyArr(map);
                checkUp(temp,x,y);
                checkRight(temp,x,y);
                checkDown(temp,x,y);
                checkLeft(temp,x,y);
                dfs(cnt+1,temp);
                break;
        }
    }
}