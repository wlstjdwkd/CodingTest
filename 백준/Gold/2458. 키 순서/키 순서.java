import java.io.*;

public class Main {
	static int n;
	static int[][] height;
	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] infor = br.readLine().split(" ");
		n = Integer.parseInt(infor[0]);
		int count = Integer.parseInt(infor[1]);
		height = new int[n][n];
		int a, b;
		while(count-- > 0) {
			infor = br.readLine().split(" ");
			a = Integer.parseInt(infor[0]) - 1;
			b = Integer.parseInt(infor[1]) - 1;		
			// 키 크면 1, 작으면 -1 대입
			height[a][b] = 1;
			height[b][a] = -1;			
		}
		compareHeight();
		System.out.println(getStudentNum());
	}

	/* Floyd-Warshall : 키 순서 알아내기 */
	private static void compareHeight() {
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(height[i][k] == 0 || height[k][j] == 0) continue;
					if(height[i][k] == height[k][j]) {
						height[i][j] = height[i][k];
					}
				}
			}
		}	
	}
	
	private static int getStudentNum() {
		int num = 0;
		for(int i=0; i<n; i++) {
			num++;
			for(int j=0; j<n; j++) {
				if(i == j) continue;
				if(height[i][j] == 0) {
					num--;
					break;
				}
			}
		}
		return num;
	}
}