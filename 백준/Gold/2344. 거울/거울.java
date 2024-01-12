import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr= new int[N+2][M+2];
        int[] result = new int[2*N+2*M+1];

        for(int i=1; i<=N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    arr[i][j]=-1;
                }
            }
        }

        //구멍 번호 채우기
        //왼쪽면, 오른쪽면 구멍 번호
        for(int i=1; i<=N; i++){
            arr[i][0] = i;
            arr[N+1-i][M+1] = N+M+i;
        }
        //위쪽면, 아래쪽면 구멍 번호
        for(int i=1; i<=M; i++){
            arr[N+1][i] = N+i;
            arr[0][M+1-i]= 2*N+M+i;
        }


        //구멍에서 빛 쏨
        //왼쪽 면 구멍
        for(int i=1; i<=N; i++){
            result[i]=lazer(i,0,0);
            result[result[i]]=i;
        }
        //아래 면 구멍
        for(int i=1; i<=M; i++){
            result[N+i]=lazer(N+1,i,2);
            result[result[N+i]]=N+i;

        }

        for(int i=1; i<=2*N+2*M; i++){
            System.out.print(result[i]+" ");
        }

    }
    private static int lazer(int y, int x, int dir){
        int ny = y +dy[dir];
        int nx = x + dx[dir];
        if(arr[ny][nx]>=1){
            return arr[ny][nx];
        }
        else if(arr[ny][nx]==-1){
            return lazer(ny,nx,(dir+2)%4);
        }
        else{
            return lazer(ny,nx,dir);
        }
    }
}