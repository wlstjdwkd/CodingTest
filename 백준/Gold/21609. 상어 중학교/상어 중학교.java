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
	static int BLACK = -1, RAINBOW = 99, EMPTY = 0;
	static int N,M, sum;
	static int[][] map;
	static int[] dx = {-1,0,1,0} , dy = {0,1,0,-1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		init(); // 입력
		
		solution(); // 풀이
		
		
		printResult();
	}
	
	static void printResult() {
		System.out.println(sum);
	}
	
	static class Block{
		int x,y,color,sum, rainbowSum;

		public Block(int x, int y, int color, int sum, int rainbowSum) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
			this.sum = sum;
			this.rainbowSum = rainbowSum;
		}
		
		public boolean compareBlock(Block other) {
			if(this.sum != other.sum) {
				return this.sum<other.sum;
			}
			
			if(this.rainbowSum != other.rainbowSum) {
				return this.rainbowSum < other.rainbowSum;
			}
			
			if(this.x != other.x) {
				return this.x<other.x;
			}
			
				return this.y < other.y;
			
		}
	}
	
	static void solution() {
		while(true) {
			Block standardBlock = findMaxBlockGroup();
			
			if(standardBlock == null) {
				return;
			}
			
			sum += standardBlock.sum * standardBlock.sum;
			
			removeBlock(standardBlock);
			
			applyGravity();
			
			rotateMap();
			
			applyGravity();
		}
	}
	
	static void rotateMap() {
		int[][] map_copy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map_copy[i][j] = map[j][N-i-1];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = map_copy[i][j];
			}
		}
	}
	
	static void removeBlock(Block block) {
		Queue<Integer> qx = new ArrayDeque<>();
		Queue<Integer> qy = new ArrayDeque<>();
		visited = new boolean[N][N];
		
		qx.offer(block.x);
		qy.offer(block.y);
		visited[block.x][block.y] = true;
		map[block.x][block.y] = EMPTY;
		
		while(!qx.isEmpty()) {
			int cx = qx.poll();
			int cy = qy.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy+ dy[i];
				if(outOfRange(nx, ny)|| map[nx][ny]== BLACK || map[nx][ny]==EMPTY || visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] != block.color) {
					if (map[nx][ny] == RAINBOW) {
						map[nx][ny] = EMPTY;
						visited[nx][ny] = true;
						qx.offer(nx);
						qy.offer(ny);
					}
					continue;
				}
				
				map[nx][ny] = EMPTY;
				visited[nx][ny] = true;
				qx.offer(nx);
				qy.offer(ny);
			}
		}
	}
	
	static void applyGravity() {
		for (int i = 0; i < N; i++) {
			for (int j = N-2; j >=0; j--) {
				if (map[j][i] == BLACK || map[j][i] == EMPTY) {
					continue;
				}
				moveBlock(j,i);
			}
		}
	}
	
	static void moveBlock(int x, int y) {
		int cx = x;
		while(true) {
			cx++;
			
			if(cx>=N) {
				break;
			}
			
			if(map[cx][y]!=EMPTY) {
				break;
			}
			
			
		}
		cx--;
		
		if(cx == x) {
			return;
		}
		
		map[cx][y] = map[x][y];
		map[x][y] = EMPTY;
	}
	
	static Block findMaxBlockGroup() {
		visited = new boolean[N][N];
		
		Block maxBlock = new Block(0,0,EMPTY, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == BLACK || map[i][j] == RAINBOW || map[i][j] == EMPTY || visited[i][j]) {
					continue;
				}
				
				initRainBowVisited();
				
				Block cur = bfsBlock(i, j, map[i][j]);
				
				
				if(cur == null) {
					continue;
				}
				
				if(maxBlock.compareBlock(cur)) {
					maxBlock = cur;
				}
			}
		}
		
		if(maxBlock.color == EMPTY) {
			return null;
		}
		return maxBlock;
	}
	
	static Block bfsBlock(int x, int y, int color) {
		Queue<Integer> qx = new ArrayDeque<>();
		Queue<Integer> qy = new ArrayDeque<>();
		qx.offer(x);
		qy.offer(y);
		
		visited[x][y] = true;
		
		int sum = 1;
		int rainbowSum = 0;
		
		while(!qx.isEmpty()) {
			int cx = qx.poll();
			int cy = qy.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					
					if(outOfRange(nx,ny)) {
						continue;
					}
					
					if(map[nx][ny] == BLACK || map[nx][ny] == EMPTY || visited[nx][ny]) {
						continue;
					}
					
					if(map[nx][ny] != color) {
						if(map[nx][ny] == RAINBOW) {
							rainbowSum++;
							sum++;
							visited[nx][ny] = true;
							qx.offer(nx);
							qy.offer(ny);
						}
						continue;
					}
					
					sum++;
					visited[nx][ny] = true;
					qx.offer(nx);
					qy.offer(ny);
				}
		}
		
		if(sum <2) {
			return null;
		}
		else {
			return new Block(x,y,color,sum,rainbowSum);
		}
	}
	
	static boolean outOfRange(int x, int y) {
		return x < 0 || x>=N || y<0 || y>=N;
	}
	
	static void initRainBowVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == RAINBOW) {
					visited[i][j] = false;
				}
			}
		}
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = 0;
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					map[i][j] = RAINBOW;
				}
			}
		}
		
	}
}