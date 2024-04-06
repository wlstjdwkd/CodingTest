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
	
	static int N,M,T;
	static List<Integer>[] al;
	static boolean change;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			al[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				al[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			rotate(x,d,k);
			change = false;
			
			for (int a = 1; a <= N; a++) {
				for (int b = 0; b < M; b++) {
					if(al[a].get(b)!=-1) {
						check(a,b,al[a].get(b));
					}
				}
			}
			
			if(!change) {
				cal();
			}
			
			
		}
		System.out.println(sum());
		
		
	}
	
	private static int sum() {
		int sum = 0;
		for (int a = 1; a <= N; a++) {
			for (int b = 0; b < M; b++) {
				if (al[a].get(b)!=-1) {
					sum+=al[a].get(b);
				}
			}
		}
		return sum;
	}
	
	private static void cal() {
		int sum = 0;
		int count = 0;
		for (int a = 1; a <=N; a++) {
			for (int b = 0; b < M; b++) {
				if (al[a].get(b) != -1) {
					sum += al[a].get(b);
					count++;
				}
			}
		}
		if(count == 0) {
			return;
		}
		double avg = (double) sum / count;
		for (int a = 1; a <=N; a++) {
			for (int b = 0; b < M; b++) {
				if (al[a].get(b) != -1) {
					if(al[a].get(b) > avg) {
						al[a].set(b, al[a].get(b)-1);
					}
					else if(al[a].get(b)<avg) {
						al[a].set(b, al[a].get(b)+1);
					}
				}
			}
		}
	}
	
	private static boolean check(int x) {
		return x>=1 && x<=N;
	}
	
	private static void check(int x, int y, int value) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(ny == M) {
				ny = 0;
			}
			else if(ny == -1) {
				ny = M-1;
			}
			
			if(check(nx) && al[nx].get(ny) == value && al[nx].get(ny) != -1) {
				al[nx].set(ny, -1);
				change = true;
				check(nx,ny,value);
			}
		}
	}
	
	private static void rotate(int x, int d, int k) {
		for (int i = 1; i <=N; i++) {
			if(i%x == 0) {
				if (d==0) {
					for (int j = 0; j < k; j++) {
						al[i].add(0, al[i].remove(al[i].size()-1));
					}
				}
				else {
					for (int j = 0; j < k; j++) {
						int number = al[i].remove(0);
						al[i].add(al[i].size(), number);
					}
				}
			}
			
		}
	}
}