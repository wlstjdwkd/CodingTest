import java.io.*;
import java.util.*;

public class Main {
	static int n,k;
	static int[] A;
	static boolean[] robot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		A = new int[2*n];
		robot = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(simulation());
	}
	
	private static int simulation() {
		int cnt = 0;
		while(isOk()) {
			int tmp = A[A.length-1];
			for (int i = A.length-1; i >0; i--) {
				A[i] = A[i-1];
			}
			A[0] = tmp;
			
			for (int i = robot.length-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			robot[n-1] = false;
			
			for (int i = robot.length-1; i >0; i--) {
				if (robot[i-1] && !robot[i] && A[i] >= 1) {
					A[i]--;
					robot[i] = true;
					robot[i-1] = false;
				}
			}
			
			if (A[0]>0) {
				robot[0] = true;
				A[0]--;
			}
			
			cnt++;
		}
		
		return cnt;
	}
	
	private static boolean isOk() {
		int cnt = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				cnt++;
			}
			if (cnt >= k) {
				return false;
			}
			
		}
		
		return true;
	}
}