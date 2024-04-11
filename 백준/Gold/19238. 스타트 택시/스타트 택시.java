import java.io.*;
import java.util.*;

public class Main {
	private static class Position implements Comparable<Position>{
		int x,y, value;

		public Position(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			if(this.value == o.value) {
				if(this.x == o.x) {
					return this.y-o.y;
				}
				return this.x-o.x;
			}
			return this.value-o.value;
		}
	}
	
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int curX, curY, curC;
	private static List<Position> humans = new ArrayList<>();
	private static int N,M,O;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		curX = Integer.parseInt(st.nextToken())-1;
		curY = Integer.parseInt(st.nextToken())-1;
		
		for (int i = 2; i < M+2; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			int ex = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			map[sx][sy] = i;
			humans.add(new Position(ex, ey, 0));
		}
		
		int count = 0;
		while(count <M) {
			int temp1 = searchCustomer();
			
			if(O-temp1 <=0 || temp1 == -1) {
				break;
			}
			
			int temp2 = searchGoal();
			if (O- (temp1+ temp2) < 0 || temp2 == -1) {
				break;
			}
			else {
				O+= temp2-temp1;
			}
			count++;
		}
		
		if(count == M) {
			System.out.println(O);
		}
		else {
			System.out.println(-1);
		}
	}
	
	private static int searchGoal() {
		PriorityQueue<Position> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		pq.add(new Position(curX,curY,0));
		visited[curX][curY]  = true;
		int gx = humans.get(curC-2).x;
		int gy = humans.get(curC-2).y;
		while(!pq.isEmpty()) {
			Position cur = pq.poll();
			if (cur.x == gx && cur.y == gy) {
				curX = gx;
				curY = gy;
				return cur.value;
			}
			
			for (int i = 0; i < 4; i++) {
				int tempX = cur.x + dx[i];
				int tempY = cur.y + dy[i];
				if (inSpace(tempX, tempY)) {
					if(!visited[tempX][tempY] && map[tempX][tempY]!=1) {
						visited[tempX][tempY] = true;
						pq.add(new Position(tempX, tempY, cur.value+1));
					}
				}
			}
		}
		return -1;
	}
	
	private static int searchCustomer() {
		PriorityQueue<Position> pq = new PriorityQueue<>();
		
		boolean[][] visited = new boolean[N][N];
		pq.add(new Position(curX, curY, 0));
		visited[curX][curY] = true;
		while(!pq.isEmpty()) {
			Position cur = pq.poll();
			if (map[cur.x][cur.y] > 1) {
				curC = map[cur.x][cur.y];
				curX = cur.x;
				curY = cur.y;
				map[curX][curY] = 0;
				return cur.value;
			}
			
			for (int i = 0; i < 4; i++) {
				int tempX = cur.x + dx[i];
				int tempY = cur.y + dy[i];
				
				if(inSpace(tempX, tempY)) {
					if(!visited[tempX][tempY] && map[tempX][tempY] != 1) {
						visited[tempX][tempY] = true;
						pq.add(new Position(tempX, tempY, cur.value+1));
					}
				}
			}
		}
		return -1;
	}
	
	private static boolean inSpace(int x, int y) {
		return 0<=x && x<N && 0<= y && y< N;
	}
}