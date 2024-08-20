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

//    private static boolean isArea(int x, int y){
//        return 0<= x && x<R && 0<=y && y<C;
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        int left = 0;
        int right = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int w = stoi(st.nextToken());

            list[a].add(new Point(b,w));
            list[b].add(new Point(a,w));
            right = Math.max(right,w);
        }

        st = new StringTokenizer(br.readLine());
        int from = stoi(st.nextToken());
        int to = stoi(st.nextToken());

        while(left<=right){
            int mid = (left+right)/2;
            ans = -1;
            check = new boolean[n+1];
            dfs(from, to, mid);
            if(ans!=-1){
                left = mid+1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    private static void dfs(int pos, int target, int limit){
        if(pos == target){
            ans = pos;
            return;
        }
        check[pos] = true;
        for(Point p : list[pos]){
            if(!check[p.x]){
                if(limit <= p.y){
                    dfs(p.x, target, limit);
                }
            }
        }
    }

    private static int ans;
    private static List<Point>[] list;
    private static boolean[] check;


}