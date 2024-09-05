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

    private static boolean isArea(int x, int y){
        return 0<= x && x<5 && 0<=y && y<9;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        attack = new int[N];
        population = new int[N];
        fullVisited = (1<<N) -1;
        DP = new int[fullVisited+1];
        Arrays.fill(DP,-1);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            attack[i] = stoi(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            population[i] = stoi(st.nextToken());
        }

        search(K,0,0,0);
        System.out.println(result);
    }

    private static void search(int hp, int save, int damage, int visited){
        result = Math.max(result,save);
        if(visited == fullVisited || hp<=damage){
            return;
        }

        for(int i=0; i<N; i++){
            int bit = (1<<i);
            if((visited & bit) > 0){
                continue;
            }

            int totlaDamage = damage+attack[i];
            int nxtHp = hp - totlaDamage;
            int nxtVisted = visited | bit;

            if(nxtHp < 0 || DP[nxtVisted] >= nxtHp){
                continue;
            }

            DP[nxtVisted] = nxtHp;
            search(nxtHp, save+population[i], totlaDamage, nxtVisted);
        }
    }

    private static int result;
    private static int N, fullVisited;
    private static int[] attack, population, DP;

}