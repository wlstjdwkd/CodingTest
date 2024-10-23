import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

//    private static boolean isArea(int x, int y){
//        return 1<=x && x<=m && 1<=y && y<=n;
//    }

    private static int n;
    private static int k;
    private static int[] d;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int tc = stoi(st.nextToken());

        for(int t = 0; t < tc; t++){
            st = new StringTokenizer(br.readLine());
            n = stoi(st.nextToken());
            k = stoi(st.nextToken());
            d = new int[n+1];

            List<List<Integer>> list = new ArrayList<>();

            for(int i=0; i<n+1; i++){
                list.add(new ArrayList<>());
            }

            int[] degree = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                d[i] = stoi(st.nextToken());
            }

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());

                int v1 = stoi(st.nextToken());
                int v2 = stoi(st.nextToken());

                list.get(v1).add(v2);
                degree[v2]++;
            }

            int w = stoi(br.readLine());

            topoSort(degree, list, w);
        }
    }

    private static void topoSort(int[] degree, List<List<Integer>> list, int w){
        Queue<Integer> q = new ArrayDeque<>();
        int[] result = new int[n+1];

        for(int i=1; i<=n; i++){
            result[i] = d[i];

            if(degree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int v = q.poll();
            for (final int i : list.get(v)) {
                degree[i]--;
                result[i] = Math.max(result[i], result[v] + d[i]);

                if(degree[i] == 0){
                    q.add(i);
                }
            }
        }

        System.out.println(result[w]);
    }



}