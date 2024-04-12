import java.io.*;
import java.util.*;

public class Main {
	static int N,R;
	static int[][] arr;
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		size = (int)Math.pow(2, N);
		arr= new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			cal(k,l);
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void cal(int k, int l) {
		int arrDiv = (int)Math.pow(2,l);
		switch (k) {
		case 1:
			one(arrDiv);
			break;
			
		case 2:
			two(arrDiv);
			break;
		case 3:
			three(arrDiv);
			break;
		case 4:
			four(arrDiv);
			break;
		case 5:
			five(arrDiv);
			break;
		case 6:
			six(arrDiv);
			break;
		case 7:
			seven(arrDiv);
			break;
		case 8:
			eight(arrDiv);
			break;
		}
	}
	
	private static void one(int div) {
		int tempDiv = div/2;
		for (int i = div; i <=size; i+=div) {
			int minus = 0;
			for (int j = i-div; j < i-tempDiv; j++) {
				minus++;
				for (int s = 0; s < size; s++) {
					int temp = arr[j][s];
					arr[j][s] = arr[i-minus][s];
					arr[i-minus][s] = temp;
				}
			}
		}
	}
	
	private static void two(int div) {
		int tempDiv = div/2;
		for (int i = div; i <=size; i+=div) {
			int minus = 0;
			for (int j = i-div; j <i-tempDiv; j++) {
				minus++;
				for (int s = 0; s < size; s++) {
					int temp = arr[s][j];
					arr[s][j] = arr[s][i-minus];
					arr[s][i-minus] = temp;
				}
			}
		}
	}
	
	private static void three(int div) {
		int[][] temp = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp[(i/div) * div + j%div][((j/div +1)*div)-1 - i%div] = arr[i][j];
			}
		}
		
		arr = temp;
	}
	private static void four(int div) {
    	int[][] temp = new int[size][size];
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			temp[(i/div+1)*div -1 - j%div][(j/div)*div + i%div] = arr[i][j];
    		}
    	}
    	arr = temp;
    }
	
	private static void five(int div) {
		for (int i = 0; i < size/2; i++) {
			int row = ((size-i-1)/div)*div + i%div;
			for (int j = 0; j < size; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[row][j];
				arr[row][j] = temp;
			}
		}
	}
	
	private static void six(int div) {
		for (int i = 0; i < size/2; i++) {
			int col = ((size-1-i)/div) * div + i%div;
			for (int j = 0; j < size; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[j][col];
				arr[j][col] = temp;
			}
		}
	}
	
	//연산 7.
    static void seven(int div) {
    	int[][] temp = new int[size][size];
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			temp[(j/div)*div + i%div][((size-1-i)/div)*div + j%div] = arr[i][j];
    		}
    	}
    	arr = temp;
    }
    
    //연산 8.
    static void eight(int div) {
    	int[][] temp = new int[size][size];
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			temp[((size-1-j)/div)*div + i%div][(i/div)*div + j%div] = arr[i][j];
    		}
    	}
    	arr = temp;
    }
}