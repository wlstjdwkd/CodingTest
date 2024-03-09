import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Tree{
        int row;
        int col;
        int age;
        boolean dead;

        public Tree(String[] tree){
            this.row = Integer.parseInt(tree[0])-1;
            this.col = Integer.parseInt(tree[1])-1;
            this.age = Integer.parseInt(tree[2]);
        }

        public Tree(int row, int col, int age){
            this.row = row;
            this.col = col;
            this.age = age;
        }
    }
    static int N,M,K;
    static int[][] foods;
    static int[][] lands;
    static ArrayList<Tree> trees = new ArrayList<>();
    static Queue<Integer> deadTrees = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        foods = new int[N][N];
        lands = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                foods[i][j] = Integer.parseInt(st.nextToken());
                lands[i][j] = 5;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            trees.add(new Tree(new String[]{st.nextToken(), st.nextToken(), st.nextToken()}));
        }

        Collections.sort(trees, (o1, o2) -> o1.age - o2.age);

        for(int i=0; i<K; i++){
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    public static void spring(){
        for(int i=0; i<trees.size(); i++){
            Tree tree = trees.get(i);
            if(lands[tree.row][tree.col] < tree.age){
                deadTrees.add(i);
                continue;
            }
            lands[tree.row][tree.col] -= tree.age;
            tree.age++;
        }
    }

    public static void summer(){
        while(!deadTrees.isEmpty()){
            int deadTreeIdx = deadTrees.poll();
            Tree deadTree = trees.get(deadTreeIdx);
            int food = deadTree.age/2;
            lands[deadTree.row][deadTree.col] += food;
            deadTree.dead = true;
        }
    }

    public static void fall(){
        // 8군데 좌표계산에 사용할 배열
        int[] moveRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] moveCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        ArrayList<Tree> newTrees = new ArrayList<>();
        for(int p = 0; p< trees.size(); p++){
            Tree tree = trees.get(p);
            if(tree.dead){
                continue;
            }
            if(tree.age % 5 == 0){
                for(int i=0; i<8; i++){
                    int newRow = tree.row + moveRow[i];
                    int newCol = tree.col + moveCol[i];
                    if(newRow < 0 || newRow >= N || newCol < 0 || newCol >= N){
                        continue;
                    }
                    newTrees.add(new Tree(newRow, newCol, 1));
                }
            }
        }
        for(Tree tree : trees){
            if(!tree.dead){
                newTrees.add(tree);
            }
        }

        trees = newTrees;
    }

    public static void winter(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                lands[i][j] += foods[i][j];
            }
        }
    }
}