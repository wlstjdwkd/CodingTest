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
	
	static int[] nums;
	static int[] arr;
	static boolean[] isVisited;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		nums = new int[N];
		
		isVisited = new boolean[N];		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		dfs(0);
		System.out.println(sb);
	}
	
	private static void dfs(int count) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				arr[count] = nums[i];
				dfs(count+1);
				isVisited[i] = false;
			}
		}
	}
}