import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Shark{
		int r,c,d;

		public Shark(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	
	static int N,M,K;
	static int[][] resttime;
	static int[][] smell;
	static int[][][] priority;
	static Shark[] shark;
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		resttime = new int[N+1][N+1];
		smell = new int[N+1][N+1];
		priority = new int[M + 1][5][4];
		shark = new Shark[M+1];
		
		for (int i = 1; i <=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <=N; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if(n>0) {
					shark[n] = new Shark(i,j,0);
					resttime[i][j] = K;
					smell[i][j] = n;
					
					
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=M; i++) {
			shark[i].d = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <=M; i++) {
			for (int j = 1; j <=4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					priority[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		System.out.println(solve());
	}
	
	private static int solve() {
		int time = 0;
		
		while(true) {
			int count = 0;
			for (int m = 1; m <=M; m++) {
				if (shark[m] != null) {
					count++;
				}
			}
			
			if (count ==1 && shark[1] != null) {
				return time;
			}
			
			if (time>=1000) {
				return -1;
			}
			
			int[][] tmp = new int [N+1][N+1];
			for (int m = 1; m <=M; m++) {
				if(shark[m] != null) {
					moveShark(tmp, m);
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <=N; j++) {
					if (resttime[i][j] > 0) {
						resttime[i][j]--;
					}
					
					if(resttime[i][j]==0) {
						smell[i][j] = 0;
					}
				}
			}
			
			for (int i = 1; i <=N; i++) {
				for (int j = 1; j <=N; j++) {
					if (tmp[i][j] > 0) {
						resttime[i][j] = K;
						smell[i][j] = tmp[i][j];
					}
				}
			}
			time++;
		}
	}
	
	private static void moveShark(int[][] tmp, int m) {
		int nr = 0;
		int nc = 0;
		int d = 0;
		boolean flag = false;
		
		for (int i = 0; i < 4; i++) {
			d = priority[m][shark[m].d][i];
			nr = shark[m].r + dr[d];
			nc = shark[m].c + dc[d];
			
			if((1<=nr && nr <= N) && (1<=nc && nc <=N)&& smell[nr][nc] == 0) {
				flag = true;
				break;
			}
		}
		
		
		if(!flag) {
			for (int i = 0; i < 4; i++) {
				d = priority[m][shark[m].d][i];
				nr = shark[m].r + dr[d];
				nc = shark[m].c + dc[d];
				
				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == m)
					break;
			}
		}
		
		if(tmp[nr][nc] == 0) {
			tmp[nr][nc] = m;
			shark[m].r = nr;
			shark[m].c = nc;
			shark[m].d = d;
		}
		else {
			shark[m] = null;
		}
	}
	
	
}