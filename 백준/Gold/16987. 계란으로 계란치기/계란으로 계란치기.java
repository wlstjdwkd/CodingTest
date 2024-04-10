import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] dura;
	static int[] weight;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		init();
		
		bt(0,0);
		
		System.out.println(max);
	}
	
	private static void bt(int idx, int cnt) {
		if(idx == N) {
			max = Math.max(max, cnt);
			return;
		}
		
		if(dura[idx]<=0 || cnt == N-1) {
			bt(idx+1, cnt);
			return;
		}
		
		int nCnt = cnt;
		for (int i = 0; i < N; i++) {
			if(i==idx) {
				continue;
			}
			
			if(dura[i] <=0) {
				continue;
			}
			
			hitEgg(idx,i);
			
			if(dura[idx] <= 0) {
				cnt++;
			}
			
			if(dura[i] <= 0) {
				cnt++;
			}
			
			bt(idx + 1, cnt);
			
			recoveryEgg(idx,i);
			cnt = nCnt;
		}
	}
	
	private static void hitEgg(int handEgg, int targetEgg) {
		dura[targetEgg] -= weight[handEgg];
		dura[handEgg] -= weight[targetEgg];
	}
	
	private static void recoveryEgg(int handEgg, int targetEgg) {
		dura[targetEgg] += weight[handEgg];
		dura[handEgg] += weight[targetEgg];	
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dura = new int[N];
		weight = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dura[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
	}
}