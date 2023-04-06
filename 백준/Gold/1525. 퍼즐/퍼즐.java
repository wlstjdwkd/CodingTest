import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String correct = "123456780";
    static Map<String, Integer> map = new HashMap<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        String ss="";
        //103425786
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                ss += st.nextToken();
            }
        }
        //키: 문자열 , value: 이동한 횟수
        map.put(ss,0);

        System.out.println(bfs(ss));
    }
    private static int bfs(String init){
        Queue<String> q = new ArrayDeque<>();
        q.add(init);
        while(!q.isEmpty()){
            String s = q.poll();
            int move = map.get(s);
            int zeroIdx = s.indexOf('0');
            int px = zeroIdx%3;
            int py = zeroIdx/3;

            if(s.equals(correct)){
                return move;
            }

            for(int i=0; i<4; i++){
                int nx = px+dx[i];
                int ny = py+dy[i];
                if(isInArea(nx,ny)){
                    int nPos = ny*3 + nx;
                    char ch = s.charAt(nPos);
                    String next = s.replace(ch,'c');
                    next = next.replace('0',ch);
                    next = next.replace('c','0');

                    //여태 이 루트로 한적 없음
                    if(!map.containsKey(next)){
                        q.add(next);
                        map.put(next,move+1);
                    }
                }
            }
        }
        return -1;
    }
    private static boolean isInArea(int x, int y){
        return 0<=x && x<=2 && 0<=y && y<=2;
    }
}