import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] check;
    static Stack<Character> stack = new Stack<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char[] chars = br.readLine().toCharArray();
            check = new int[26];
            int length = chars.length;
            for(char now : chars){
                check[now-'a']++;
            }

            dfs(chars, length);
            while(!pq.isEmpty()){
                sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(char[] s, int length){
        if(stack.size() == length){
            StringBuilder sb = new StringBuilder();
            for(char now : stack){
                sb.append(now);
            }
            pq.add(sb.toString());
            return;
        }

        for(int i=0; i<26; i++){
            if(check[i]>0){
                check[i]--;
                stack.push((char)(i+'a'));
                dfs(s, length);
                stack.pop();
                check[i]++;
            }
        }
    }
}