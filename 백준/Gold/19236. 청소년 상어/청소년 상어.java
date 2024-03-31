import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Shark{
        int x, y, dir, eatSum;
        public Shark(int x, int y, int dir, int eatSum){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eatSum = eatSum;
        }
    }

    static class Fish{
        int x, y, id, dir;
        boolean isAlive;
        public Fish(int x, int y, int id, int dir, boolean isAlive){
            this.x = x;
            this.y = y;
            this.id = id;
            this.dir = dir;
            this.isAlive = isAlive;
        }
    }

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[4][4];
        List<Fish> fishes = new ArrayList<>();

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken())-1;
                fishes.add(new Fish(i, j, a, b, true));
                arr[i][j] = a;
            }
        }

        Collections.sort(fishes, (a, b) -> a.id - b.id);

        Fish f = fishes.get(arr[0][0]-1);
        Shark shark = new Shark(0, 0, f.dir, f.id);

        f.isAlive = false;
        arr[0][0] = -1;

        dfs(arr, shark, fishes);
        System.out.println(maxSum);
    }

    static void dfs(int[][] arr, Shark shark, List<Fish> fishes){
        if(maxSum < shark.eatSum){
            maxSum = shark.eatSum;
        }

        fishes.forEach(e-> moveFish(e, arr, fishes));

        for(int dist = 1; dist<4; dist++){
            int nx = shark.x + dx[shark.dir]*dist;
            int ny = shark.y + dy[shark.dir]*dist;
            if(0<=nx && nx<4 && 0<=ny && ny<4 && arr[nx][ny]>0){
                int[][] arrCopies = copyArr(arr);
                List<Fish> fishesCopies = copyFishes(fishes);

                arrCopies[shark.x][shark.y] = 0;
                Fish fish = fishesCopies.get(arr[nx][ny]-1);
                Shark sharkCopy = new Shark(nx, ny, fish.dir, shark.eatSum+fish.id);
                fish.isAlive = false;
                arrCopies[nx][ny] = -1;

                dfs(arrCopies, sharkCopy, fishesCopies);
            }
        }
    }

    static void moveFish(Fish fish, int[][] arr, List<Fish> fishes){
        if(!fish.isAlive) return;
        for(int i=0; i<8; i++){
            int nextDir = (fish.dir+i)%8;
            int nx = fish.x + dx[nextDir];
            int ny = fish.y + dy[nextDir];

            if(0<=nx && nx<4 && 0<=ny && ny<4 && arr[nx][ny]>-1){
                arr[fish.x][fish.y] = 0;
                if (arr[nx][ny] != 0) {
                    Fish temp = fishes.get(arr[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;
                    arr[fish.x][fish.y] = temp.id;

                }
                fish.x = nx;
                fish.y = ny;
                arr[nx][ny] = fish.id;
                fish.dir = nextDir;
                return;
            }
        }
    }

    static int[][] copyArr(int[][] arr){
        int[][] temp = new int[4][4];

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    static List<Fish> copyFishes(List<Fish> fishes){
        List<Fish> temp = new ArrayList<>();

        for(Fish f : fishes){
            temp.add(new Fish(f.x, f.y, f.id, f.dir, f.isAlive));
        }
        return temp;
    }
}