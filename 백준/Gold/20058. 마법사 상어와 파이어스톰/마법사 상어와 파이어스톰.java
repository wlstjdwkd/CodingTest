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
	private static int n,q;
	private static int[][] map;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int land, totalIce;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		n = (int) Math.pow(2,n);
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int[] L = new int[q];
		
		for (int i = 0; i < q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < q; i++) {
			map = divide(L[i]);
			map = melt();
		}
		
		biggest();
		System.out.println(totalIce);
		System.out.println(land);
		
	}
	
	private static void biggest() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				totalIce += map[i][j];
				if(map[i][j]>0 && !visit[i][j]) {
					q.add(new int[] {i, j});
					visit[i][j] = true;
					int cnt = 1;
					
					while(!q.isEmpty()) {
						int[] t = q.poll();
						int tx = t[0];
						int ty = t[1];
						
						for (int k = 0; k < 4; k++) {
							int nx = tx + dx[k];
							int ny = ty + dy[k];
							if(nx>=0 && nx <n && ny>=0 && ny<n) {
								if(map[nx][ny] > 0 && !visit[nx][ny]) {
									visit[nx][ny] = true;
									q.add(new int[] {nx, ny});
									cnt++;
								}
							}
						}
					}
					
					land = Math.max(land, cnt);
				}
			}
		}
	}
	
	private static int[][] melt(){
		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; i++) {
			tmp[i] = Arrays.copyOf(map[i], n);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				if(map[i][j] == 0) {
					continue;
				}
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >= 0 && nx < n && ny>=0 && ny < n) {
						if(map[nx][ny] > 0) {
							cnt++;
						}
					}
				}
				
				if(cnt<3) {
					tmp[i][j]--;
				}
			}
		}
		return tmp;
	}
	
	private static int[][] divide (int L) {
		int[][] tmp = new int[n][n];
		L=(int) Math.pow(2, L);
		for (int i = 0; i < n; i+=L) {
			for (int j = 0; j <n ; j+=L) {
				rotate(i,j,L,tmp);
			}
		}
		
		return tmp;
	}
	
	private static void rotate(int x, int y, int L, int[][] tmp) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				tmp[x+i][y+j] = map[x+L-1-j][y+i];
			}
		}
	}
}