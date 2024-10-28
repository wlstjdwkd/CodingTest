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
        for(int i=0; i<=N; i++){
            a.add(new ArrayList<>());
        }

        int[] degree = new int[N+1];
        int[] times = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            times[i] = stoi(st.nextToken());
            while(true){
                int num = stoi(st.nextToken());
                if(num == -1){
                    break;
                }

                a.get(num).add(i);

                degree[i]++;
            }
        }

        String ans = toposort(a, degree, times, N);

        System.out.println(ans);
    }

    private static String toposort(List<List<Integer>> a,int[] degree, int[] times, int N){
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }

        int[] result = new int[N+1];

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : a.get(now)){
                degree[next]--;

                result[next] = Math.max(result[next], result[now] + times[now]);

                if(degree[next] == 0){
                    q.add(next);
                }
            }
        }

        for(int i=1; i<=N; i++){
            sb.append(result[i] + times[i]).append("\n");
        }

        return sb.toString();
    }


}