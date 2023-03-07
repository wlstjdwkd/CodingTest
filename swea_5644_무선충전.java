
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5644_무선충전 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    //이동 방향
    //0-이동하지 않음 (0,0)
    //1-상
    //2-우
    //3-하
    //4-좌
    static int[] dx = {0,0,1,0,-1};
    static int[] dy = {0,-1,0,1,0};

    //최종 결과값
    static int result;
    //A와 B 이동방향을 담은 배열
    static int[] moveA;
    static int[] moveB;
    //배터리 저장 배열

    static BC[] BCs;
    //배터리 개수
    static int BCnum;


    //A와 B의 X,Y 좌표
    //A는 1,1에서 시작
    //B는 10,10에서 시작
    static int xxA;
    static int yyA;
    static int xxB;
    static int yyB;


    //충전기 정보 class
    static class BC{
        //x, y, 충전범위, 처리량
        int x;
        int y;
        int range;
        int power;

        public BC(int x, int y, int range, int power) {
            this.x = x;
            this.y = y;
            this.range = range;
            this.power = power;
        }
    }
    public static void main(String[] args) throws IOException {
        //사용자(2명)가 충전한 양의 합의 최댓값 구하기
//        1. 지도의 가로, 세로 크기는 10이다.
//        2. 사용자는 총 2명이며, 사용자A는 지도의 (1, 1) 지점에서, 사용자B는 지도의 (10, 10) 지점에서 출발한다.
//        3. 총 이동 시간 M은 20이상 100이하의 정수이다. (20 ≤ M ≤ 100)
//        4. BC의 개수 A는 1이상 8이하의 정수이다. (1 ≤ A ≤ 8)
//        5. BC의 충전 범위 C는 1이상 4이하의 정수이다. (1 ≤ C ≤ 4)
//        6. BC의 성능 P는 10이상 500이하의 짝수이다. (10 ≤ P ≤ 500)
//        7. 사용자의 초기 위치(0초)부터 충전을 할 수 있다.
//        8. 같은 위치에 2개 이상의 BC가 설치된 경우는 없다. 그러나 사용자A, B가 동시에 같은 위치로 이동할 수는 있다. 사용자가 지도 밖으로 이동하는 경우는 없다.
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            result = 0;
            xxA=1;
            xxB=10;
            yyA=1;
            yyB=10;
            st = new StringTokenizer(br.readLine());
            //총 이동 시간
            int M = Integer.parseInt(st.nextToken());
            //BC(충전기)의 개수
            BCnum = Integer.parseInt(st.nextToken());

            //A와 B의 이동정보 배열
            moveA = new int[M];
            moveB = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                moveA[i]= Integer.parseInt(st.nextToken());
            }
            st= new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                moveB[i]= Integer.parseInt(st.nextToken());
            }

            BCs = new BC[BCnum];

            for(int i=0; i<BCnum; i++){
                st= new StringTokenizer(br.readLine());
                //x, y, 충전범위, 처리량
                BCs[i] = new BC(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }

            //0초부터 검사
            charge();
            for(int i=0; i<M;i++){
                xxA += dx[moveA[i]];
                yyA += dy[moveA[i]];
                xxB += dx[moveB[i]];
                yyB += dy[moveB[i]];
                charge();
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    //충전 가능 검사 함수
    private static void charge(){

        //BC_A, BC_B
        //각각 A와 B 방문 저장 배열
        //충전기 범위 안에 왔을 때 1
        int[] BC_A = new int[BCnum];
        int[] BC_B = new int[BCnum];
        //A와 B의 충전소 방문 횟수
        int cntA=0;
        int cntB=0;
        //최댓값
        int max=0;
        for(int i=0; i<BCnum; i++){
            //충전기 개수만큼 for문
            BC bc = BCs[i];
            //거리 계산 => 사용자와와 충전기의 X좌표와 Y좌표 차이 절댓값
            //A 충전 가능
            if(Math.abs(xxA-bc.x)+Math.abs(yyA-bc.y)<=bc.range){

                cntA++;
                BC_A[i]=1;
            }

            //B 충전 가능
            if(Math.abs(xxB-bc.x)+Math.abs(yyB-bc.y)<=bc.range){
                cntB++;
                BC_B[i]=1;

            }
        }

        if(cntA==0 && cntB==0){
            //둘 다 충전 불가
            return;
        }

        //A만 충전
        //한번에 여러 지역을 밟을 수 있는데
        //그 중 젤 높은걸 선택해야 하기 때문에 max선택
        if(cntB==0){
            max=0;
            for(int i=0; i<BCnum; i++){
                if(BC_A[i]==0){
                    continue;
                }
                //충전소를 두개 이상 밟았을 경우의 max
                max=Math.max(max,BCs[i].power);

            }
            result+=max;
            return;
        }

        //B만 충전
        if(cntA==0){
            max=0;
            for(int i=0; i<BCnum; i++){
                if(BC_B[i]==0){
                    continue;
                }
                max = Math.max(max,BCs[i].power);
            }
            result+=max;
            return;
        }

        //A랑 B가 둘다 들러버렸음
        max=0;
        for(int i=0; i<BCnum; i++){
            if(BC_A[i]==0){
                continue;
            }
            else{
                int tempA = BCs[i].power;
                for(int j=0; j<BCnum; j++){
                    if(BC_B[j]==0){
                        continue;
                    }
                    else{
                        int tempB = BCs[j].power;

                        //둘이 다른 충전기
                        if(i!=j){
                            max = Math.max(tempA+tempB,max);

                        }
                        //둘이 같은거
                        else{
                            max = Math.max(tempA,max);

                        }
                    }
                }
            }
        }
        result+=max;
    }
}