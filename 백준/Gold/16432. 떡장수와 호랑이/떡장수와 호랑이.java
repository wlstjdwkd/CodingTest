import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Integer>> al;
    private static int[][] visit;
    private static String result = "-1";
    static int chk;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        al = new ArrayList<>();
        visit = new int[N][10];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<k; j++){
                temp.add(Integer.parseInt(st.nextToken()));
            }
            al.add(temp);
        }

        for(int i=0; i<al.get(0).size(); i++){
            visit[0][al.get(0).get(i)] = 1;
            if(dfs(al.get(0).get(i),1)){
                chk = 1;
                break;
            }
        }
        if(chk == 1){
            for(int i = result.length()-1; i>=0; i--){
                sb.append(result.charAt(i)).append("\n");
            }
        }
        else{
            sb.append(result);
        }
        System.out.println(sb);
    }

    private static boolean dfs(int prev, int day){
        if(day == N){
            result = prev + "";
            return true;
        }
        for(int i=0; i< al.get(day).size(); i++){
            if(al.get(day).get(i) == prev || visit[day][al.get(day).get(i)] == 1){
                continue;
            }
            visit[day][al.get(day).get(i)] = 1;
            if (dfs(al.get(day).get(i), day + 1)) {
                result += prev + "";
                return true;
            }
        }
        return false;
    }
}