import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] cheese;
	static int initialCheeseCount = 0, cheeseCount = 0;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		/* 입력 및 변수 초기화 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cheese = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {		
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j] == 1) {
					initialCheeseCount++;
				}
			}
		}
		
		int time = 0, lastCheeseCount = 0;
		
		while(cheeseCount < initialCheeseCount) {
			time++;
			lastCheeseCount = initialCheeseCount - cheeseCount;
			meltCheese();
		}
		
		/* 출력 */
		System.out.println(time);
		System.out.println(lastCheeseCount);
		
	}
	
	/* BFS : 공기와 맞닿은 치즈 조각 녹이기 */
	private static void meltCheese() {
		visited = new boolean[n][m];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[]{0, 0});
		
		while(!q.isEmpty()) {
			int[] point = q.poll();

			for(int i=0; i<4; i++) {
				int nx = dx[i] + point[0];
				int ny = dy[i] + point[1];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				
				// 치즈 조각인 경우
				if(cheese[nx][ny] == 1) {
					cheese[nx][ny] = 0;
					cheeseCount++;
					continue;
				}
				
				// 치즈가 아닌 경우
				q.add(new int[] {nx, ny});
			}
		}
	}

}