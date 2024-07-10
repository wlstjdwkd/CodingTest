import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int n = stoi(br.readLine());
        int count[]  = new int[MAX];
        int index[] = new int[n];
        int ans[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            index[i] = stoi(st.nextToken());
            count[index[i]]++;
        }

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && count[index[i]] > count[index[stack.peek()]]){
                ans[stack.pop()] = index[i];
            }

            stack.push(i);
        }
        while(!stack.empty()) {
            ans[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    static final int MAX = 1_000_001;

}