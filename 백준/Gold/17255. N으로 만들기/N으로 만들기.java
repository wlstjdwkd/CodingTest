import java.io.*;
import java.util.*;

public class Main {
	
	private static final int[] dx = {-1, 0, 0, 1};
	private static final int[] dy = {0, -1, 1, 0};
	
	
//	private static boolean isRange(int x, int y) {
//		return 0 <= x && x<n && 0<= y && y<n;
//	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	private static char[] arr;
	private static Set<String> set;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		init();
		
		for(int i=0; i<arr.length; i++) {
			dfs(i,i, ""+arr[i], ""+arr[i]);
		}
		System.out.println(set.size());
	}
	
	private static void dfs(int L, int R, String s, String path) {
		if(L==0 && R== arr.length-1) {
			set.add(path);
			return;
		}
		
		if(L-1>=0) {
			dfs(L-1, R, arr[L-1] + s, path+" "+arr[L-1] + s);
		}
		
		if(R+1<arr.length) {
			dfs(L, R+1, s+arr[R+1], path+" "+s+arr[R+1]);
		}
	}
	
	
	private static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		
		arr = st.nextToken().toCharArray();
		set = new HashSet<String>();
	}
	
	
}