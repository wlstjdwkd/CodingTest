import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] abcd = new int[n][4];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                abcd[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[n*n];
        int[] cd = new int[n*n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ab[i*n+j] = abcd[i][0] + abcd[j][1];
                cd[i*n+j] = abcd[i][2] + abcd[j][3];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        int abp = 0;
        int cdp = n*n-1;
        long cnt = 0;
        while(abp<n*n && cdp > -1){
            long abv = ab[abp], cdv = cd[cdp];
            long res = abv + cdv;
            if(res<0){
                abp++;
            }
            else if(res>0){
                cdp--;
            }
            else{
                long xc = 0, yc = 0;
                while(abp<n*n && abv == ab[abp]){
                    abp++;
                    xc++;
                }
                while(cdp>-1 && cdv == cd[cdp]){
                    cdp--;
                    yc++;
                }

                cnt+= xc*yc;
            }
        }
        System.out.println(cnt);
    }
}