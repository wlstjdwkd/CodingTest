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
	static int n,m,g,r;
	static int[][] map;
	static boolean[][] red_visited;
	static boolean[][] green_visited;
	static int ans;
	static boolean[] dfs_visited;
	static int[][] red_time;
	static int[][] green_time;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[][] copy_map;
	
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static List<Node> dfs_list = new ArrayList<>();
	
	static List<Node> green = new ArrayList<>();
	static List<Node> red = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		init();
		
		dfs_visited = new boolean[dfs_list.size()];
		
		green_dfs(0,0);
		
		System.out.println(ans);
	}
	
	private static void green_dfs(int level, int now) {
		if(level == g) {
			green.clear();
			for (int i = 0; i < dfs_list.size(); i++) {
				if (dfs_visited[i]) {
					Node a = dfs_list.get(i);
					green.add(a);
				}
			}
			
			red_dfs(0,0);
			return;
		}
		
		for (int i = now; i < dfs_list.size(); i++) {
			if(!dfs_visited[i]) {
				dfs_visited[i] = true;
				green_dfs(level+1, i+1);
				////////////////////////////////////////////
				dfs_visited[i] = false;
			}
		}
	}
	
	public static void red_dfs(int level, int now) {
        if(level == r) {
            red.clear();
            for(int i=0; i<dfs_list.size(); i++) {
                Node a = dfs_list.get(i);
                if(dfs_visited[i] && !green.contains(a)) {
                    red.add(a);
                }
            }
            bfs();
            return ;
        }
        for(int i=now; i<dfs_list.size(); i++) {
            if(!dfs_visited[i]) {
                dfs_visited[i] = true;
                red_dfs(level+1,i+1);
                dfs_visited[i]=false;
            }
        }
    }
	
	private static void copy_map() {
		copy_map = new int[n+1][m+1];
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=m; j++) {
				copy_map[i][j] = map[i][j];
			}
		}
	}
	
	private static void bfs() {
		int flower = 0;
		green_visited = new boolean[n+1][m+1];
		green_time = new int[n+1][m+1];
		red_visited = new boolean[n+1][m+1];
		red_time = new int[n+1][m+1];
		
		copy_map();
		Queue<Node> rq = new ArrayDeque<>();
		Queue<Node>gq = new ArrayDeque<>();
		
		for (int i = 0; i < red.size(); i++) {
			rq.add(red.get(i));
			red_visited[red.get(i).x][red.get(i).y] = true;
		}
		
		for (int i = 0; i < green.size(); i++) {
			gq.add(green.get(i));
			green_visited[green.get(i).x][green.get(i).y] = true;
		}
		
		while(!rq.isEmpty() && !gq.isEmpty()) {
			if(!gq.isEmpty()) {
				int rep = gq.size();
				while(rep-- !=0) {
					Node a = gq.poll();
					green_visited[a.x][a.y] = true;
					if (copy_map[a.x][a.y] == 3) {
						continue;
					}
					
					for (int i = 0; i < 4; i++) {
						int nx = a.x+dx[i];
						int ny = a.y+dy[i];
						
						if(isRange(nx,ny) && (copy_map[nx][ny] ==1 || copy_map[nx][ny] == 2) && !green_visited[nx][ny]) {
							green_visited[nx][ny] = true;
							green_time[nx][ny] = green_time[a.x][a.y] +1;
							gq.add(new Node(nx,ny));
						}
					}
				}
			}
			
			if(!rq.isEmpty()) {
                int rep = rq.size();
                    while(rep-- !=0) {
                    Node a = rq.poll();
                    red_visited[a.x][a.y] = true;
        
                    if(copy_map[a.x][a.y]==3) {
                        continue;
                    }
                    for(int i=0; i<4; i++) {
                        int nx = a.x+dx[i];
                        int ny = a.y+dy[i];
                        if(isRange(nx,ny) && (copy_map[nx][ny]==1 || copy_map[nx][ny]==2) && !red_visited[nx][ny]) {
                            red_visited[nx][ny] = true;
                            red_time[nx][ny] = red_time[a.x][a.y]+1;
                            if(red_time[nx][ny]==green_time[nx][ny]) {
                                
                                flower++;
                                copy_map[nx][ny]=3;
                            }
                            else {
                                rq.add(new Node(nx,ny));
                            }
                        }
                    }
                } 
			}
		}
		ans = Math.max(ans, flower);
	}
	
	private static boolean isRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=m;
	}
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		
		for (int i = 1; i <=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					dfs_list.add(new Node(i,j));
				}
			}
		}
	}
	
}