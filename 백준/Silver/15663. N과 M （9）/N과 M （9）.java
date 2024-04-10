import java.io.*;
import java.util.*;

public class Main {
	
	private static int[] numArr;
	private static int[] out;
	private static boolean[] visited;
	private static int M;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		numArr = new int[N];
		visited = new boolean[N];
		out = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numArr);
		
		dfs(0);
		
	}
	
	private static void dfs(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(out[i]+" ");
			}
			System.out.println();
			return;
		}
		
		int before = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				if(before != numArr[i]) {
					visited[i] = true;
					out[cnt] = numArr[i];
					before =numArr[i];
					dfs(cnt+1);
					visited[i] = false;
				}
			}
		}
	}
}