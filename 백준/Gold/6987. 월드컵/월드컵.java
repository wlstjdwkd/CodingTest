import java.awt.Point;
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {0,1,0,-1};
    private static final int[] dy = {-1,0,1,0};

//    private static boolean isArea(int x, int y){
//        return 0<=x && x<m && 0<=y && y<n;
//    }

    private static final int MAX_TEAM_COUNT = 6;
    private static int[][] matches;
    private static boolean isEndGame = false;

    public static void main(String[] args) throws IOException{

        int tc = 4;
        int size = 0;
        for(int i=1; i< MAX_TEAM_COUNT; i++){
            size+=i;
        }

        matches = new int[size][2];
        int idx = 0;
        for(int i=0; i<MAX_TEAM_COUNT; i++){
            for(int j=i+1; j<MAX_TEAM_COUNT; j++){
                matches[idx][0] = i;
                matches[idx][1] = j;
                idx++;
            }
        }

        while(tc-->0){
            st = new StringTokenizer(br.readLine());
            int[][] worldCup = new int[3][MAX_TEAM_COUNT];
            boolean isPossible = true;

            for(int i=0; i<MAX_TEAM_COUNT; i++){
                int win = stoi(st.nextToken());
                int draw = stoi(st.nextToken());
                int lose = stoi(st.nextToken());

                worldCup[0][i] = win;
                worldCup[1][i] = draw;
                worldCup[2][i] = lose;

                if(win+draw+lose != 5){
                    isPossible = false;
                    break;
                }
            }

            if(isPossible){
                backTracking(worldCup, 0, size);
                if(isEndGame){
                    sb.append(1);
                }
                else{
                    sb.append(0);
                }
            }
            else{
                sb.append(0);
            }

            sb.append(" ");
            isEndGame = false;
        }
        System.out.println(sb);

    }

    private static void backTracking(int[][] worldCup, int matchCount, int size){
        if(isEndGame){
            return;
        }
        if(matchCount == size){
            isEndGame = true;
            return;
        }

        int myTeam = matches[matchCount][0];
        int enemyTeam = matches[matchCount][1];

        if(worldCup[0][myTeam] > 0 && worldCup[2][enemyTeam] > 0){
            worldCup[0][myTeam]--;
            worldCup[2][enemyTeam]--;
            backTracking(worldCup, matchCount + 1, size);
            worldCup[0][myTeam]++;
            worldCup[2][enemyTeam]++;
        }

        if(worldCup[1][myTeam] > 0 && worldCup[1][enemyTeam] > 0){
            worldCup[1][myTeam]--;
            worldCup[1][enemyTeam]--;
            backTracking(worldCup, matchCount + 1, size);
            worldCup[1][myTeam]++;
            worldCup[1][enemyTeam]++;
        }

        if(worldCup[2][myTeam] > 0 && worldCup[0][enemyTeam] > 0){
            worldCup[2][myTeam]--;
            worldCup[0][enemyTeam]--;
            backTracking(worldCup, matchCount + 1, size);
            worldCup[2][myTeam]++;
            worldCup[0][enemyTeam]++;
        }

    }

}