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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A-64 = 1

        for(int i=0; i<5; i++) {
            String str = br.readLine();
            for(int j=0; j<9; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='x') {
                    list.add(new Point(i,j));
                }
                else if(map[i][j]!='.') {
                    visited[map[i][j]-65] = true;
                }
            }
        }
        dfs(0);
    }

    private static void dfs(int idx){
        if(idx == list.size()){
            if(check()){
                for(int i=0; i<5; i++){
                    for(int j=0; j<9; j++){
                        System.out.print(map[i][j]);
                    }
                    System.out.println();
                }
                System.exit(0);
            }
            else{
                return;
            }
        }
        for(int i=0; i<12; i++){
            if(!visited[i]){
                Point a = list.get(idx);
                char alpha = (char) (65+i);
                map[a.x][a.y] = alpha;
                visited[i] = true;
                dfs(idx+1);
                visited[i] = false;
                map[a.x][a.y] = '.';
            }
        }

    }

    private static boolean check() {
        int sum1 = (map[0][4]-'A'+1) + (map[1][3]-'A'+1)+ (map[2][2]-'A'+1)+(map[3][1]-'A'+1);
        int sum2 = (map[0][4]-'A'+1)+(map[1][5]-'A'+1)+(map[2][6]-'A'+1)+(map[3][7]-'A'+1);
        int sum3 = (map[1][1]-'A'+1)+(map[1][3]-'A'+1)+(map[1][5]-'A'+1)+(map[1][7]-'A'+1);
        int sum4 = (map[3][1]-'A'+1)+(map[3][3]-'A'+1)+(map[3][5]-'A'+1)+(map[3][7]-'A'+1);
        int sum5 = (map[4][4]-'A'+1)+(map[3][3]-'A'+1)+(map[2][2]-'A'+1)+(map[1][1]-'A'+1);
        int sum6 = (map[4][4]-'A'+1)+(map[3][5]-'A'+1)+(map[2][6]-'A'+1)+(map[1][7]-'A'+1);

        if(sum1==26 && sum2 ==26 && sum3==26 && sum4==26 && sum5==26 && sum6==26) {
            return true;
        }
        return false;
    }

    static char map[][] = new char[5][9];
    static boolean visited[] = new boolean[13];
    static List<Point> list = new ArrayList<>();



}