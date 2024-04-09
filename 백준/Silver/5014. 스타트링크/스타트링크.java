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
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[F+1];
		System.out.println(BFS(F,S,G,U,D,arr));
	}
	
	private static String BFS(int Floor, int start, int end, int up, int down, int[] arr) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		arr[start] = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			if(current == end) {
				return String.valueOf(arr[current]-1);
			}
			
			if(current +up <=Floor) {
				if(arr[current+up] == 0) {
					arr[current+up] = arr[current]+1;
					q.add(current+up);
				}
			}
			
			if(current - down > 0) {
				if(arr[current-down] == 0) {
					arr[current-down] = arr[current] +1;
					q.add(current-down);
				}
			}
		}
		
		return "use the stairs";
	}
}