import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea_5650_핀볼게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int max,N;
    static int[][] map;
    //왼 오 위 아래
    static int[] dx={0,0,-1,1};
    static int[] dy ={-1,1,0,0};
    static int[][] wormHole;

    static class Ball{
        int x,y,d;

        public Ball(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine());
        for(int tc =1; tc<=T; tc++){
            max =0;
//            N = sc.nextInt();
            N = Integer.parseInt(br.readLine().trim());
            wormHole  = new int[11][4];
            map = new int[N][N];

            for(int i=0; i<11; i++){
                Arrays.fill(wormHole[i],-1);
            }
//            Arrays.fill(wormHole,-1);

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
//                    map[i][j] = sc.nextInt();
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]>5){
                        if(wormHole[map[i][j]][0] == -1) {
                            wormHole[map[i][j]][0] = i;
                            wormHole[map[i][j]][1] = j;
                        } else {
                            wormHole[map[i][j]][2] = i;
                            wormHole[map[i][j]][3] = j;
                        }
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==0){
                        for(int d=0; d<4; d++){
                            Ball b = new Ball(i,j,d);
                            max = Math.max(max,play(b));
                        }
                    }
                }
            }



            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static int play(Ball start){
        int startX = start.x;
        int startY = start.y;
        int startD = start.d;
        int score =0;
        while(true){
            startX+=dx[startD];
            startY+=dy[startD];

            //벽 만나면 반대방향으로 튕김
            if(startX<0 || startY<0 || startX>=N || startY>=N){
                score++;
                switch(startD){
                    case 0:
                        startD =1;
                        break;
                    case 1:
                        startD =0;
                        break;
                    case 2:
                        startD =3;
                        break;
                    case 3:
                        startD=2;
                        break;
                }
                continue;
            }

            //블랙홀 || 시작점 =>끝남
            if(map[startX][startY] ==-1 || (startX ==start.x && startY ==start.y)){
                return score;
            }

            //아무것도 없음
            if(map[startX][startY]==0){
                continue;
            }

            //웜홀
            int temp = map[startX][startY];

            if(map[startX][startY]>5){
                if(wormHole[temp][0]==startX
                        &&wormHole[temp][1]==startY){
                    startX = wormHole[temp][2];
                    startY = wormHole[temp][3];
                }
                else{
                    startX = wormHole[temp][0];
                    startY = wormHole[temp][1];
                }
                continue;
            }

            //블록만나면

            switch(temp){
                case 1:
                    score++;
                    switch(startD){
                        case 0:
                            //왼쪽으로 오면 위
                            startD=2;
                            break;
                        case 1:
                            //오른쪽 - 왼쪽
                            startD=0;
                            break;
                        case 2:
                            //위 - 아래
                            startD =3;
                            break;
                        case 3:
                            //아래 - 오른쪽
                            startD=1;
                            break;

                    }
                    break;
                case 2:
                    score++;
                    switch(startD){
                        case 0:
                            //왼쪽으로 오면 아래
                            startD=3;
                            break;
                        case 1:
                            //오른쪽 - 왼쪽
                            startD=0;
                            break;
                        case 2:
                            //위 - 오른쪽
                            startD =1;
                            break;
                        case 3:
                            //아래 - 위
                            startD=2;
                            break;
                    }
                    break;
                case 3:
                    score++;
                    switch(startD){
                        case 0:
                            //왼쪽으로 오면 오른쪽
                            startD=1;
                            break;
                        case 1:
                            //오른쪽 - 아래
                            startD=3;
                            break;
                        case 2:
                            //위 - 왼쪽
                            startD =0;
                            break;
                        case 3:
                            //아래 - 위
                            startD=2;
                            break;
                    }
                    break;
                case 4:
                    score++;
                    switch(startD){
                        case 0:
                            //왼쪽으로 오면 오른쪽
                            startD=1;
                            break;
                        case 1:
                            //오른쪽 - 위
                            startD=2;
                            break;
                        case 2:
                            //위 - 아래
                            startD =3;
                            break;
                        case 3:
                            //아래 - 왼
                            startD=0;
                            break;
                    }
                    break;
                case 5:
                    score++;
                    switch(startD){
                        case 0:
                            startD =1;
                            break;
                        case 1:
                            startD =0;
                            break;
                        case 2:
                            startD =3;
                            break;
                        case 3:
                            startD=2;
                            break;
                    }
                    break;


            }

        }
    }


}
