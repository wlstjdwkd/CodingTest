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
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[] dc = {1,1,2,2};
	static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
	static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
	            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
	static int[] sandRatio = {1,1,2,7,7,2,10,10,5};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = calculateOutSand(N/2, N/2);
		System.out.println(result);
	}
	
	private static int calculateOutSand(int x, int y) {
		int totalOutSand = 0;
		int currentX = x;
		int currentY = y;
		while(true) {
			for (int d = 0; d < 4; d++) {
				for (int moveCount = 0; moveCount < dc[d]; moveCount++) {
					int nextX = currentX+dx[d];
					int nextY = currentY + dy[d];
					
					if(nextX<0 || nextY<0 || nextX>=N || nextY>=N) {
						return totalOutSand;
					}
					
					int sand = map[nextX][nextY];
					map[nextX][nextY] = 0;
					int spreadTotal = 0;
					for (int spread = 0; spread < 9; spread++) {
						int sandX = nextX +dsx[d][spread];
						int sandY = nextY + dsy[d][spread];
						int spreadAmount = (sand*sandRatio[spread])/100;
						
						if(sandX<0 || sandX>=N || sandY<0 || sandY>=N) {
							totalOutSand += spreadAmount;
						}
						else {
							map[sandX][sandY] += spreadAmount;
						}
						
						spreadTotal += spreadAmount;
						
					}
					
					int alphaX= nextX+dx[d];
					int alphaY = nextY+dy[d];
					int alphaAmount = sand - spreadTotal;
					
					if(alphaX<0 || alphaX>=N || alphaY <0 || alphaY>=N) {
						totalOutSand += alphaAmount;
					}
					else {
						map[alphaX][alphaY] += alphaAmount;
					}
					
					currentX = nextX;
					currentY = nextY;
					
				}
			}
			for (int index = 0; index < 4; index++) {
				dc[index] +=2;
			}
		}
	}
}