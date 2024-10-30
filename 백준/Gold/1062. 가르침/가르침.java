import java.awt.Point;
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

    private static int n, k;
    private static String[] word;
    private static boolean[] anta;
    private static int max;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        k = stoi(st.nextToken());
        word = new String[n];
        anta = new boolean[26];
        anta['a' - 'a'] = true;
        anta['n' - 'a'] = true;
        anta['t' - 'a'] = true;
        anta['i' - 'a'] = true;
        anta['c' - 'a'] = true;

        if(k<5){
            System.out.println(0);
        }
        else if(k == 26){
            System.out.println(n);
        }
        else{
            for(int i=0; i<n; i++){
                String str = br.readLine();
                str = str.replace("anta", "");
                str = str.replace("tica", "");

                word[i] = str;
            }

            backtracking(0,0);

            System.out.println(max);
        }


    }

    private static void backtracking(int start, int depth){
        if(depth == k-5){
            int cnt = 0;
            for(int i=0; i<n; i++){
                String str = word[i];
                boolean flag = true;
                for(int j=0; j<str.length(); j++){
                    char c = str.charAt(j);
                    if(!anta[c-'a']){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        for(int i=start; i<26; i++){
            if(!anta[i]){
                anta[i] = true;
                backtracking(i+1, depth+1);
                anta[i] = false;
            }
        }
    }



}