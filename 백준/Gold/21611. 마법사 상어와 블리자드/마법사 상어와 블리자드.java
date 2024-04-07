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
	static int N,M;
	static int[][] map;
	static int d[], s[];
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static int res;
	static int xy[][];
	
	static int nextDir[] = {0,3,4,2,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		d = new int[M];
		s = new int[M];
		xy = new int[N*N][2];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		setxy();
		simulation();
		System.out.println(res);
	}
	
	private static void simulation() {
		for (int time = 0; time < M; time++) {
			breakRing(d[time],s[time]);
			
			moveInside();
			
			while(true) {
				if(!bomb4()) {
					break;
				}
				
				else {
					moveInside();
				}
			}
			
			split2();
		}
	}
	
	private static void split2() {
		int newMap[][] = new int[N][N];
		
		int cnt = 1;
		int num = 1;
		int cx = 0, cy = 0, nx = 0, ny = 0;
		for (int i = 1; i < N*N; i++) {
			cx = xy[i][0];
			cy = xy[i][1];
			if(map[cx][cy] == 0) {
				break;
			}
			
			if(i != N*N -1) {
				nx = xy[i+1][0];
				ny = xy[i+1][1];
			}
			if (i!=N*N-1 && map[cx][cy] == map[nx][ny]) {
				cnt++;
			}
			else {
				if(num >=N*N) {
					break;
				}
				
				int newx = xy[num][0];
				int newy = xy[num][1];
				num++;
				
				if(num>=N*N) {
					break;
				}
				
				int newx2 = xy[num][0];
				int newy2 = xy[num][1];
				
				num++;
				newMap[newx][newy] = cnt;
				newMap[newx2][newy2] = map[cx][cy];
				cnt =1;
			}
		}
		map = newMap;
	}
	
	private static int[][] copy(int[][] map) {
		int data[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				data[i][j] = map[i][j];
		}
		return data;
	}
	
	private static boolean bomb4() {
		int x = N/2, y = N/2;
		int nx = 0, ny = 0;
		int curDir = 3;
		
		int d =1;
		int cnt = 0;
		List<int[]> list = new ArrayList<>();
		boolean flag = false;
		
		while(true) {
			if(x==0 && y ==0 ) {
				break;
			}
			
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < d; i++) {
					if(x==0 && y==0) {
						return flag;
					}
					nx =x + dx[curDir];
					ny = y+dy[curDir];
					
					if(cnt == 0 && map[x][y]!=0 && map[x][y] == map[nx][ny]) {
						cnt+=2;
						list.add(new int[] {x,y});
						list.add(new int[] {nx,ny});
					}
					
					else if(cnt != 0 && map[x][y] != 0 && map[x][y] == map[nx][ny]) {
						cnt++;
						list.add(new int[] {nx,ny});
					}
					
					if(map[x][y] != map[nx][ny]) {
						if(cnt>=4) {
							flag= true;
							for (int j = 0; j < list.size(); j++) {
								int cur[] = list.get(j);
								int cx = cur[0], cy = cur[1];
								res += map[cx][cy];
								map[cx][cy] = 0;
							}
						}
						
						cnt = 0;
						list.clear();
					}
					
					x=nx;
					y=ny;
				}
				
				curDir = nextDir[curDir];
			}
			d++;
		}
		return flag;
	}
	
	private static int[] find(int num) {
		int nxy[] = new int[2];
		
		for (int i = num; i < N*N; i++) {
			int cx = xy[i][0];
			int cy = xy[i][1];
			if(map[cx][cy]!=0) {
				nxy[0] = cx;
				nxy[1] = cy;
				break;
			}
		}
		
		return nxy;
	}
	
	private static void moveInside() {
		for (int i = 1; i < N*N; i++) {
			int cx = xy[i][0];
			int cy = xy[i][1];
			if(map[cx][cy] == 0) {
				int[] nxy = find(i);
				
				int nx = nxy[0];
				int ny = nxy[1];
				map[cx][cy] = map[nx][ny];
				map[nx][ny] = 0;
			}
		}
	}
	
	private static void breakRing(int d, int s) {
		int nx = N/2, ny =N/2;
		for (int i = 0; i < s; i++) {
			nx+=dx[d];
			ny +=dy[d];
			if(nx<0 || nx>=N || ny<0 || ny>=N) {
				break;
			}
			map[nx][ny] = 0;
		}
	}
	
	private static void setxy() {
		int x = N/2, y = N/2;
		int nx = 0;
		int ny = 0;
		int curDir = 3;
		int num = 1;
		int d = 1;
		
		while(true) {
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < d; i++) {
					if(x==0 && y==0) {
						return;
					}
					
					nx = x +dx[curDir];
					ny = y + dy[curDir];
					
					xy[num][0] = nx;
					xy[num][1] = ny;
					num++;
					
					x=nx;
					y=ny;
				}
				
				curDir = nextDir[curDir];
			}
			d++;
		}
	}
	
	
}