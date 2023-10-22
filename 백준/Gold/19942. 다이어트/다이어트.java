import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] arr;
    private static int result = Integer.MAX_VALUE;
    private static int[] min_nutrution = new int[4];
    private static int[] isSelected;
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][5];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            min_nutrution[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            isSelected = new int[N];
            dfs(0,i,1);
        }

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else{
            Collections.sort(list);
            System.out.println(result);
            System.out.println(list.get(0));

        }
    }

    static void dfs(int cnt, int choiceNum, int start){
        if(cnt == choiceNum){
            isCheck(choiceNum);
            return;
        }
        for(int i=start; i<=N; i++){
            isSelected[cnt] = i;
            dfs(cnt+1, choiceNum, i+1);
            isSelected[cnt] = 0;
        }
    }

    private static void isCheck(int choiceNum){
        int sum_nutrition[] = new int[4];
        int price = 0;

        for(int i=0; i<choiceNum; i++){
            for(int j=0; j<4; j++){
                sum_nutrition[j] += arr[isSelected[i]][j];
            }
            price += arr[isSelected[i]][4];
        }

        for(int i=0; i<4; i++){
            if(min_nutrution[i] > sum_nutrition[i])return;
        }
            if(result >= price){
                if(result > price){
                    list.clear();
                }

                StringBuilder sb = new StringBuilder();

                for(int j=0; j<choiceNum; j++){
                    sb.append(isSelected[j]).append(" ");

                }

                list.add(sb.toString());
                result = price;
            }

    }
}