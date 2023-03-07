import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] players;
    static boolean[] select;
    static int[] lineUp;
    static int result;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        players = new int[N+1][10];
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++){
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        select = new boolean[10];
        lineUp = new int[10];

        select[4]=true;
        lineUp[4]=1;
        perm(2);
        System.out.println(result);

    }
    private static void perm(int num) {
        if (num == 10) {
            play();
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (select[i]) {
                continue;
            }
            select[i] = true;
            lineUp[i] = num;
            perm(num + 1);
            select[i] = false;
        }
    }

    private static void play() {
        int score = 0;
        int startPlayer = 1;
        boolean[] base;

        for (int i = 1; i < N+1; i++) {
            int outCnt = 0;
            base = new boolean[4];

            outer: while (true) {
                for (int j = startPlayer; j < 10; j++) {
                    int hitter = players[i][lineUp[j]];

                    switch (hitter) {
                        case 0: // out.
                            outCnt++;
                            break;
                        case 1: // 1루타
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    if (k == 3) { // 3루 => 홈
                                        score++; // 점수 획득
                                        base[k] = false; // 3루 빔
                                        continue;
                                    }

                                    // 1, 2루에 => 다음 base
                                    base[k] = false;
                                    base[k + 1] = true;
                                }
                            }
                            base[1] = true; // 1루
                            break;
                        case 2: // 2루타
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    if (k == 3 || k == 2) {
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    base[k] = false;
                                    base[k + 2] = true;
                                }
                            }
                            base[2] = true;
                            break;
                        case 3: // 3루타
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }

                            base[3] = true; // 홈에서 3루로 진루.
                            break;
                        case 4: // 홈런
                            for (int k = 1; k <= 3; k++) {
                                if (base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            score++;
                            break;
                    }

                    if (outCnt == 3) {
                        startPlayer = j + 1;
                        if (startPlayer == 190) {
                            startPlayer = 0;
                        }
                        break outer;
                    }
                }
                startPlayer = 1;
            }
        }

        result = result<=score ? score : result;
    }

}