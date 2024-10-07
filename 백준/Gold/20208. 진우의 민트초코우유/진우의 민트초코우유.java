import java.io.*;
import java.util.*;

public class Main {
	
	
	
	private static final int[] dx = {-1,0,1,0};
	private static final int[] dy = {0,1,0,-1};
	
	private static boolean isRange(int x, int y) {
		return 0 <= x && x<N && 0<= y && y<N;
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	private static int N,M,H,max;
	
	private static boolean[] visit;
	
	private static int sr, sc;
	
	private static List<Pair> p;
	private static class Pair{
		int r,c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		H = stoi(st.nextToken());
		int[][] map = new int[N][N];
		
		p = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = stoi(st.nextToken());
				
				if(map[i][j] == 1) {
					sr = i;
					sc = j;
				}
				
				else if(map[i][j] == 2) {
					p.add(new Pair(i,j));
				}
			}
		}
		
		visit = new boolean[p.size()];
		int[] arr = new int[p.size()];
		perm(0,arr);
		System.out.println(max);
		
	}
	
	private static void perm(int idx, int[] arr) {
		if(idx == p.size()) {
			findMint(arr);
			return;
		}
		
		for(int i=0; i<p.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[idx] = i;
				perm(idx+1, arr);
				visit[i] = false;
			}
		}
	}
	
	private static void findMint(int[] arr) {
		int hp = M;
		int r = sr;
		int c = sc;
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			int k = arr[i];
			int dist = Math.abs(r - p.get(k).r) + Math.abs(c - p.get(k).c);
			int toHome = Math.abs(sr-p.get(k).r) + Math.abs(sc - p.get(k).c);
			if(hp >= dist) {
				cnt++;
				hp-=dist;
				hp+=H;
				if(hp>=toHome) {
					max = Math.max(max, cnt);
				}
				
				r = p.get(k).r;
				c = p.get(k).c;
			}
			
			else {
				return;
			}
		}
	}
	
	
	
	
}