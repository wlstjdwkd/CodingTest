import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;
    private static final int LENGTH = 101;

    private static boolean[][] map = new boolean[LENGTH][LENGTH];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            draw(x, y, getDirections(d, g));
        }

        System.out.println(getNumberOfSquares());
    }

    private static List<Integer> getDirections(int d, int g){
        List<Integer> directions = new ArrayList<>();
        directions.add(d);
        while(g-->0){
            for(int i = directions.size()-1; i>=0; i--){
                int direction = (directions.get(i)+1)%4;
                directions.add(direction);
            }
        }
        return directions;
    }

    private static void draw(int x, int y, List<Integer>directions){
        map[x][y] = true;

        for(int direction : directions){
            switch(direction){
                case RIGHT :
                    map[++x][y] = true;
                    break;
                case UP :
                    map[x][--y] = true;
                    break;
                case LEFT :
                    map[--x][y] = true;
                    break;
                case DOWN :
                    map[x][++y] = true;
                    break;
            }
        }
    }

    private static int getNumberOfSquares(){
        int count = 0;

        for(int x=0; x<LENGTH-1; x++){
            for(int y=0; y<LENGTH-1; y++){
                if(map[x][y] && map[x+1][y] && map[x][y+1] && map[x+1][y+1]){
                    count++;
                }
            }
        }

        return count;
    }
}