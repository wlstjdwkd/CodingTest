import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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




    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());

        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= N; i++){
            a.add(new ArrayList<>());
        }

        int[] degree = new int[N+1];
        int[] time = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            time[i] = stoi(st.nextToken());

            int num = stoi(st.nextToken());
            for(int j=0; j< num; j++){
                int temp = stoi(st.nextToken());
                a.get(temp).add(i);
                degree[i]++;
            }
        }

        System.out.println(toposort(N, a, degree, time));
    }

    private static int toposort(int N, List<List<Integer>> a, int[] degree, int[] time){
        Queue<Integer> q = new ArrayDeque<>();

        int[] result = new int[N+1];

        for(int i=1; i<=N; i++){

            result[i] = time[i];

            if(degree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : a.get(now)){

                result[next] = Math.max(result[next], result[now] + time[next]);

                degree[next]--;

                if(degree[next] == 0){
                    q.add(next);
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=N; i++){
            ans = Math.max(ans, result[i]);
        }

        return ans;
    }



}