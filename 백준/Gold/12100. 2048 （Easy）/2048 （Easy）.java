import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, answer, map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        game(0);
        System.out.println(answer);
    }

    private static void game(int count){
        if(count == 5){
            findMax();
            return;
        }
        int[][] copy = new int[N][N];

        for(int i=0; i<N; i++){
            copy[i] = map[i].clone();
        }

        for(int i=0; i<4; i++){
            move(i);
            game(count+1);
            for(int a=0; a<N; a++){
                map[a] = copy[a].clone();
            }
        }
    }

    private static void move(int dir){
        switch(dir){
            //위로 몰기
            case 0:
                for(int i=0; i<N; i++){
                    int index = 0;
                    int block = 0;
                    for(int j=0; j<N; j++){
                        if(map[j][i]!=0){
                            if(block == map[j][i]){
                                map[index-1][i] = block*2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else{
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index++][i] = block;
                            }
                        }
                    }
                }
                break;
            //아래로 몰기
            case 1:
                for(int i=0; i<N; i++){
                    int index = N-1;
                    int block = 0;
                    for(int j=N-1; j>=0; j--){
                        if(map[j][i]!=0){
                            if(block == map[j][i]){
                                map[index+1][i] = block*2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else{
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index--][i] = block;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 2:
                for(int i=0; i<N; i++){
                    int index = 0;
                    int block = 0;
                    for(int j=0; j<N; j++){
                        if(map[i][j] != 0){
                            if(block == map[i][j]){
                                map[i][index-1] = block*2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else{
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index++] = block;
                            }
                        }
                    }
                }
                break;
            //오른쪽으로 몰기
            case 3:
                for(int i=0; i<N; i++){
                    int index = N-1;
                    int block = 0;
                    for(int j=N-1; j>=0; j--){
                        if(map[i][j] != 0){
                            if(block == map[i][j]){
                                map[i][index+1] = block*2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else{
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index--] = block;
                            }
                        }
                    }
                }
                break;
        }
    }

    private static void findMax(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer = Math.max(answer, map[i][j]);
            }
        }
    }
}