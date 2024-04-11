import java.io.*;
import java.util.*;

public class Main {
	static class Seat{
		int x,y,emptyCnt, friendCnt;

		public Seat(int x, int y, int emptyCnt, int friendCnt) {
			super();
			this.x = x;
			this.y = y;
			this.emptyCnt = emptyCnt;
			this.friendCnt = friendCnt;
		}
		
	}
	
	static int N, studentNum;
	static int[][] map;
	static Map<Integer, int[]> hashMap = new HashMap<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int score = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N= Integer.parseInt(br.readLine());
		
		studentNum = N *N;
		map = new int[N][N];
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			
			int student = Integer.parseInt(st.nextToken());
			int[] likeFriends = new int[4];
			for (int j = 0; j < likeFriends.length; j++) {
				likeFriends[j] = Integer.parseInt(st.nextToken());
			}
			
			hashMap.put(student, likeFriends);
			
			putStudentSeat(student);
		}
		
		getScore();
		System.out.println(score);
	}
	
	private static void putStudentSeat(int student) {
		int[] friends = hashMap.get(student);
		List<Seat> seats = new ArrayList<>();
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int friendCnt = 0;
				int emptyCnt = 0;
				
				for (int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if(!outOfRange(nx, ny)) continue;

                    //좋아하는 친구가 있는지 확인
                    for(int f=0; f<4; f++) {
                        if(map[ny][nx] == friends[f]) friendCnt++;
                    }

                    //빈 공간인지 확인
                    if(map[ny][nx] == 0) emptyCnt++;
					
					
				}
				seats.add(new Seat(x, y, emptyCnt, friendCnt));
			}
		}
		
		seats.sort((s1, s2) -> {
			if (s1.friendCnt == s2.friendCnt) {
				if(s1.emptyCnt == s2.emptyCnt) {
					if(s1.y == s2.y) {
						return s1.x - s2.x;
					}
					return s1.y -s2.y;
				}
				return s2.emptyCnt-s1.emptyCnt;
			}
			
			return s2.friendCnt -s1.friendCnt;
		});
		
		for (Seat seat : seats) {
			if (map[seat.y][seat.x] != 0) {
				continue;
			}
			map[seat.y][seat.x] = student;
			return;
		}
	}
	
	private static void getScore() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int cnt = 0;
                int[] friends = hashMap.get(map[y][x]);

                //네 방향으로 친구 위치 확인하기
                for(int d=0; d<4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if(!outOfRange(nx, ny)) continue;

                    //옆에 좋아하는 친구가 있는지 판단하기
                    for (int f=0; f<4; f++) {
                        if(map[ny][nx] == friends[f]) {
                            cnt++;
                        }
                    }
                }
                
                switch (cnt) {
				case 1:
					score++;
					break;
				case 2:
					score+=10;
					break;
				case 3:
					score+=100;
					break;
				case 4:
					score +=1000;
					break;
				}
			}
		}
	}
	
	private static boolean outOfRange(int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
}