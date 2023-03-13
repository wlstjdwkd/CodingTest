import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num2239스도쿠 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map = new int[9][9];
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        for(int i=0; i<9; i++){
            String s = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = s.charAt(j)-'0';

                if(map[i][j]==0){
                    list.add(new int[] {i,j});
                }
            }
        }
        play(0);
    }

    private static void play(int cnt){
        if(list.size() == cnt){
            print();
            System.exit(0);
        }

        int x= list.get(cnt)[0];
        int y = list.get(cnt)[1];

        boolean[] check = new boolean[10];

        //가로 check
        for(int i=0; i<9; i++){
            if(map[x][i] !=0){
                check[map[x][i]]=true;
            }
        }

        //세로 check
        for(int i=0; i<9; i++){
            if(map[i][y]!=0){
                check[map[i][y]]=true;
            }
        }

        //네모 check
        int startX  = (x/3)*3;
        int startY = (y/3)*3;
        for(int i=startX; i<startX+3; i++){
            for(int j=startY; j<startY+3; j++){
                if(map[i][j]!=0){
                    check[map[i][j]]=true;
                }
            }
        }

        for(int i=1; i<10; i++){
            if(!check[i]){
                map[x][y] = i;
                play(cnt+1);
                map[x][y]=0;
            }
        }
    }
    private static void print(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}