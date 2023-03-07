import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr;
    static int[][] newArr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++){
            int num = Integer.parseInt(st.nextToken());
            switch(num){
                case 1:
                    num1();
                    break;
                case 2:
                    num2();
                    break;
                case 3:
                    num3();
                    break;
                case 4:
                    num4();
                    break;
                case 5:
                    num5();
                    break;
                case 6:
                    num6();
                    break;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void num1(){
        newArr = new int[N][M];
        for(int i=0; i<N;i++){
            for(int j=0; j<M; j++){
                newArr[N-i-1][j] = arr[i][j];
            }
        }
        arr = newArr;
    }
    private static void num2(){
        newArr = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                newArr[i][M-j-1] = arr[i][j];
            }
        }
        arr= newArr;
    }
    private static void num3(){
        newArr = new int[M][N];
        int C = N-1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                newArr[j][C] = arr[i][j];
            }
            C--;
        }

        int temp = N;
        N=M;
        M=temp;

        arr= newArr;
    }
    private static void num4(){
        newArr = new int[M][N];
        int C = N-1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                newArr[M-j-1][i] = arr[i][j];
            }
            C--;
        }

        int temp = N;
        N=M;
        M=temp;

        arr= newArr;
    }
    private static void num5(){
        newArr = new int[N][M];
        int nMid = N/2;
        int mMid = M/2;
        for(int i=0; i<nMid; i++){
            for(int j=0; j<mMid; j++){
                newArr[i][mMid+j] = arr[i][j];
            }
        }
        for(int i=0; i<nMid; i++){
            for(int j=mMid; j<M; j++){
                newArr[nMid+i][j] = arr[i][j];
            }
        }
        for(int i=nMid; i<N; i++){
            int C=0;
            for(int j=mMid; j<M; j++, C++){
                newArr[i][C] = arr[i][j];
            }
        }
        int row = 0;
        for(int i=nMid; i<N; i++, row++){
            for(int j=0; j<mMid; j++){
                newArr[row][j] = arr[i][j];
            }
        }
        arr = newArr;
    }
    private static void num6(){
        newArr = new int[N][M];
        int nMid = N/2;
        int mMid = M/2;
        for(int i=0; i<nMid; i++){
            for(int j=0; j<mMid; j++){
                newArr[nMid+i][j] = arr[i][j];
            }
        }
        for(int i=nMid; i<N; i++){
            for(int j=0; j<mMid; j++){
                newArr[i][mMid+j] = arr[i][j];
            }
        }
        int row = 0;
        for(int i=nMid; i<N; i++, row++){
            for(int j=mMid; j<M; j++){
                newArr[row][j] = arr[i][j];
            }
        }
        for(int i=0; i<nMid; i++){
            int C=0;
            for(int j=mMid; j<M; j++, C++){
                newArr[i][C] = arr[i][j];
            }
        }

        arr = newArr;
    }
}
