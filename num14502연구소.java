//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class num14502연구소 {
//    static int n,m;
//    static final int dx[] = {0,0,1,-1};
//    static final int dy[] = {1,-1,0,0};
//    static int maxSafeZone = Integer.MIN_VALUE;
//    static int originalMap[][];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        for(int i=0; i<n; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0; j<m; j++){
//                originalMap[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        dfs(0);
//
//        System.out.println(maxSafeZone);
//    }
//
//    static void dfs(int wallCnt){
//        if(wallCnt == 3){
//            bfs
//        }
//    }
//}
