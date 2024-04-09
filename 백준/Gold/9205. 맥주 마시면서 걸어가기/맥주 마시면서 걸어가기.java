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
	static int n, sx, sy, dx, dy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			List<int []> list = new ArrayList<>();
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(i == 0) {
					sx = x;
					sy = y;
				}
				else if(i == n+1) {
					dx = x;
					dy = y;
				}
				else {
					list.add(new int[] {x,y});
				}
			}
			sb.append(bfs(list) ? "happy\n" : "sad\n");
		}
		System.out.println(sb.toString());
	}
	
	private static boolean bfs(List<int[]> list) {
		Queue<int[]> q = new ArrayDeque<>();
		
		boolean[] visited = new boolean[n];
		q.add(new int[] {sx, sy});
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0];
			int py = pos[1];
			
			if(Math.abs(px-dx) + Math.abs(py-dy) <= 1000) {
				return true;
			}
			
			for (int i = 0; i < n; i++) {
				if(!visited[i]) {
					int nx = list.get(i)[0], ny =list.get(i)[1];
					int dis = Math.abs(px-nx) + Math.abs(py-ny);
					if(dis<=1000) {
						visited[i] = true;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		return false;
	}
}