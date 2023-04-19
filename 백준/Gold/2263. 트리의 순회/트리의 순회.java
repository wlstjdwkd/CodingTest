import java.io.*;
import java.util.*;

public class Main {
	static int[] inOrder;
	static int[] inOrderIdx;
	static int[] postOrder;
	
	public static void main(String[] args) throws IOException {
		
		/* 입력 및 변수 초기화 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		inOrder = new int[n+1];
		inOrderIdx = new int[n+1];
		postOrder = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			inOrderIdx[inOrder[i]] = i;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		getPreOrder(0, n, 0, n); // inOrder의 시작 idx, inOrder의 끝idx, postOrder의 시작 idx, postOrder의 끝 idx
	}

	/* recursive : 인오더와 포스터오더로 프리오더 구하기 */
	private static void getPreOrder(int startI, int endI, int startP, int endP) {
		if(startI >= endI || startP >= endP) return;
		int p = postOrder[endP-1];
		int index = inOrderIdx[p];
		System.out.print(p + " ");
		getPreOrder(startI, index, startP, startP+(index-startI));
		getPreOrder(index+1, endI, index-startI+startP, endP-1);
	}
}