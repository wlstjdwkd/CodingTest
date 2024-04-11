import java.io.*;
import java.util.*;

public class Main {
	private static class Point{
		private int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static char[][] map;
	static boolean[] key;
	static List<Point>[] gates;
	private static boolean[][] visited;
	private static int h,w;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h+2][w+2];
			visited = new boolean[h+2][w+2];
			key = new boolean[26];
			gates = new ArrayList[26];
			
			count = 0;
			
			for (int i = 0; i < 26; i++) {
				gates[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < h+2; i++) {
				for (int j = 0; j < w+2; j++) {
					map[i][j]= '.';
				}
			}
			
			for (int i = 1; i <=h; i++) {
				String s = br.readLine();
				for (int j = 1; j <=w; j++) {
					map[i][j] = s.charAt(j-1);
				}
			}
			
			String keyInput = br.readLine();
			
			if(!keyInput.equals("0")) {
				for (int i = 0; i < keyInput.length(); i++) {
					int temp = keyInput.charAt(i)- 'a';
					key[temp] = true;
				}
			}
			
			bfs();
			System.out.println(count);
		}
	}
	
	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny =p.y +dy[i];
				
				if(isRange(nx,ny)) {
					if(map[nx][ny] == '*' || visited[nx][ny]) {
						continue;
					}
					
					int elem = map[nx][ny];
					if(elem - 'A' >=0 && elem- 'A' <= 25) {
						//문
						if(key[elem-'A']) {
							map[nx][ny] = '.';
							visited[nx][ny] = true;
							q.add(new Point(nx,ny));
						}
						else {
							gates[elem-'A'].add(new Point(nx,ny));
						}
					}
					else if(elem-'a' >= 0 && elem-'a' <=25) {
						//열쇠
						key[elem-'a'] = true;
						visited[nx][ny] = true;
						q.add(new Point(nx,ny));
						
						for (int j = 0; j <=25; j++) {
							if (gates[j].size() !=0 && key[j]) {
								for (int z = 0; z < gates[j].size(); z++) {
									Point temp = gates[j].get(z);
									map[temp.x][temp.y] = '.';
									visited[temp.x][temp.y] = true;
									q.add(new Point(temp.x,temp.y));
								}
							}
						}
					}
					
					else if(elem == '$') {
						count++;
						visited[nx][ny] = true;
						q.add(new Point(nx,ny));
					}
					else {
						visited[nx][ny] = true;
						q.add(new Point(nx,ny));
					}
				}
			}
		}
		
	}
	
	private static boolean isRange(int x, int y) {
		return 0<=x && x<h+2 && 0<=y && y<w+2;
	}
}