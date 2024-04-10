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
	
	static int gear[][];
	static int d[];
	static int n,m;
	static int k;
	
	public static void main(String[] args) throws IOException {
		init();
	}
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			
			int gearN = Integer.parseInt(st.nextToken()) - 1;
			int turn = Integer.parseInt(st.nextToken());
			
			d = new int[4];
			d[gearN] = turn;
			checkDir(gearN);
			
			gearTurn();
		}
		
		int ans = 0;
		if(gear[0][0] == 1) ans+=1;
		if(gear[1][0] == 1) ans+=2;
		if(gear[2][0] == 1) ans+=4;
		if(gear[3][0] == 1) ans+=8;
		System.out.println(ans);
		
	}
	
	private static void gearTurn() {
		int temp = 0;
		for (int i = 0; i < 4; i++) {
			if(d[i] == 1) {
				temp = gear[i][7];
				for (int j = 7; j > 0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				
				gear[i][0] = temp;
			}
			
			else if(d[i]== -1) {
				temp = gear[i][0];
				for (int j = 0; j < 7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
			}
		}
	}
	
	private static void checkDir(int gearN) {
		for (int i = gearN-1; i >=0; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				d[i] = -d[i+1];
			}
			else {
				break;
			}
		}
		
		for (int i = gearN+1; i < 4; i++) {
			if (gear[i][6] != gear[i-1][2]) {
				d[i] = -d[i-1];
			}
			else {
				break;
			}
		}
	}
}