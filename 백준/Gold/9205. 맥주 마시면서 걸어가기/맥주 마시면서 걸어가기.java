import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] location; // 집, 편의점, 페스티벌의 위치
	static boolean[][] map; // i,j까지 갈 수 있는지
	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			n = Integer.parseInt(br.readLine()) + 2;
			location = new int[n][2];
			map = new boolean[n][n];
			String[] infor;
			for(int i=0; i<n; i++) {
				infor = br.readLine().split(" ");
				for(int j=0; j<n; j++) {		
					location[i][0] = Integer.parseInt(infor[0]);
					location[i][1] = Integer.parseInt(infor[1]);
				}
				
			}
			
			makeMap();
			gotoFestival();
			
			/* 실행 */
			if(map[0][n-1]) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	/* map초기화  */
	private static void makeMap() {
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(Math.abs(location[i][0] - location[j][0]) + Math.abs(location[i][1] - location[j][1]) <= 1000) {
					map[i][j] = true;
					map[j][i] = true;
				}
			}
		}		
	}

	/* Floyd Warshall : 페스티벌에 가기 */
	private static void gotoFestival() {;
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][k] && map[k][j]) {
						map[i][j] = true;
					}
				}
			}
		}
	}
}