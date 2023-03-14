import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;

    static char[][] map;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        map = new char[N][M];
        parents = new int[N*M];
        for(int i=0; i<parents.length; i++){
            parents[i] = i;
        }
//        for(int i=0; i<N; i++){
//            String s = br.readLine();
//            for(int j=0; j<M; j++){
//                map[i][j] = s.charAt(j);
//            }
//        }

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int cur = i*M +j;
                int next = findIdx(i,j);
                if(find(cur)!=find(next)){
                    union(cur,next);
                }
            }
        }
        int res=0;
        res = findSaveZone();
        System.out.println(res);

    }

    private static int findSaveZone(){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< parents.length; i++){
            set.add(find(i));
        }
        return set.size();
    }

    private static int findIdx(int x,int y){
        int nx= x;
        int ny = y;
        if(map[x][y] == 'U'){
            nx--;
        }
        else if(map[x][y] == 'D'){
            nx++;
        }
        else if(map[x][y] == 'L'){
            ny--;
        }
        else if(map[x][y] == 'R'){
            ny++;
        }

        return nx*M +ny;
    }

    private static int find(int x){
        if(parents[x]==x){
            return x;
        }
        return parents[x]=find(parents[x]);
    }
    private static void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x>y){
            parents[x]=y;
        }
        else{
            parents[y]= x;
        }
    }
}