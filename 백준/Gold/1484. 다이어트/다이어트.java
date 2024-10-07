import java.io.*;
import java.util.*;

public class Main {
	
	
	
	private static final int[] dx = {-1,0,1,0};
	private static final int[] dy = {0,1,0,-1};
	
	private static boolean isRange(int x, int y) {
		return 0 <= x && x<l && 0<= y && y<l;
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	
	
	private static class Knight{
		int r,c,h,w,k,bef_k;

		public Knight(int r, int c, int h, int w, int k, int bef_k) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
			this.w = w;
			this.k = k;
			this.bef_k = bef_k;
		}
		
	}
	
	private static int l,n,q;
	private static int[][] info;
	private static int[] nr;
	private static int[] nc;
	private static int[] dmg;
	private static boolean[] is_moved;
	
	private static Knight[] knights;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		int n = stoi(br.readLine());
		
		long s = 1;
		long e = 2;
		
		boolean flag = false;
		while(e<100000) {
			long ps = s*s;
			long pe = e*e;
			if(pe-ps == n) {
				System.out.println(e);
				flag = true;
			}
			
			if(pe - ps > n) {
				s++;
			}
			else {
				e++;
			}
		}
		
		if(!flag) {
			System.out.println(-1);
		}
	}
	
	
	
	
}