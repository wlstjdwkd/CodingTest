import java.util.*;
import java.io.*;

public class Main {
	public static int N, M;
	public static int arr[], result[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		result = new int[M];
		DFS(0);
		
		System.out.println(sb);
	}
	
	public static void DFS(int depth) {
		if(depth == M) {
			for(int val : result)
				sb.append(val).append(" ");
			
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
				result[depth] = arr[i];
				DFS(depth + 1);
		}
	}
}