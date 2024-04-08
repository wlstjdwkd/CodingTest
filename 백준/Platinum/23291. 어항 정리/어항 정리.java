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
	static final int INF = 987654321;
	static int N,K;
	static int[][] map;
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	private static void solution() {
		int time = 0;
		while(!isFinish()) {
			time++;
			pushFish();
			
			make2D();
			adjustFish();
			
			make1D();
			
			fold();
			
			adjustFish();
			
			make1D();
		}
		System.out.println(time);
		
	}
	
	private static void fold() {
		List<Integer> list = new ArrayList<>();
		int pivotX =1;
		int yCnt = 1;
		for (int cnt = 1; cnt <=2; cnt++) {
			
			int _y = N-yCnt*2+1;
			for (int y = N; y > N - yCnt; y--) {
				list.clear();
				for (int x = pivotX; x < pivotX + (N - pivotX +1)/2; x++) {
					list.add(map[y][x]);
					map[y][x] =0;
				}
				for (int idx = 0; idx <list.size(); idx++) {
					map[_y][N-idx] = list.get(idx);
				}
				_y++;
			}
			
			yCnt *=2;
			pivotX += N/2;
		}
	}
	
	private static void make1D() {
		List<Integer> list = new ArrayList<>();
		for (int x = 1; x <=N; x++) {
			for (int y = N; y >=1; y--) {
				if (map[y][x] == 0) {
					break;
				}
				
				list.add(map[y][x]);
				map[y][x] = 0;
			}
		}
		
		for (int i = 0; i < N; i++) {
			map[N][i+1] = list.get(i);
		}
	}
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map= new int[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <=N; i++) {
			map[N][i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	
	private static boolean isIn(int x, int y) {
		return 1<=x && x<=N && 1<= y && y<=N;
	}
	
	private static void adjustFish() {
		int[][] adjustMap = new int[N+1][N+1];
		
		for (int y = 1; y <=N; y++) {
			for (int x = 1; x <=N; x++) {
				if(map[y][x] == 0) {
					continue;
				}
				
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x+dx[d];
					
					if(!isIn(nx,ny) || map[ny][nx] == 0) {
						continue;
					}
					
						
						int diff = map[y][x] - map[ny][nx];
						
						diff/=5;
						if(diff>0) {
							adjustMap[y][x] -= diff;
							adjustMap[ny][nx] += diff;
						}
					
				}
			}
		}
		
		for (int y = 1; y <=N; y++) {
			for (int x = 1; x <=N; x++) {
				map[y][x] +=adjustMap[y][x];
			}
		}
	}
	
	private static void make2D() {
		int pivotX = 1;
		int w = 1;
		int h = 1;
		int idx = 0;
		
		while(pivotX - 1 + w + h <= N) {
			idx++;
			for (int x = pivotX; x < pivotX + w; x++) {
				for (int y = N; y > N-h; y--) {
					int ny = N - w + x - pivotX;
					int nx = pivotX + w+ N-y;
					
					map[ny][nx] = map[y][x];
					map[y][x] = 0;
				}
			}
			
			pivotX += w;
			if (idx % 2 ==0) {
				w++;
			}
			else {
				h++;
			}
		}
	}
	
	private static void pushFish() {
		List<Integer> posList = new ArrayList<>();
		int min = INF;
		for (int i = 1; i <=N; i++) {
			if (map[N][i] < min) {
				min = map[N][i];
				posList.clear();
				posList.add(i);
			}
			else if(map[N][i] == min) {
				posList.add(i);
			}
		}
		
		for (int idx : posList) {
			map[N][idx]++;
		}
	}
	
	private static boolean isFinish() {
		int max = 0;
		int min = INF;
		for (int y = 1; y <=N; y++) {
			for (int x = 1; x <=N; x++) {
				if(map[y][x] == 0) {
					continue;
				}
				
				if(max<map[y][x]) {
					max = map[y][x];
				}
				if(min>map[y][x]) {
					min = map[y][x];
				}
			}
		}
		
		if (max-min<=K) {
			return true;
		}
		else {
			return false;
		}
	}
}