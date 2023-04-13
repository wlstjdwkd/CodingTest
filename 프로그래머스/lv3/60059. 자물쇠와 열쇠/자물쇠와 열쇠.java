import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;

class Solution {
    
    int[][] bottom, left, right, eLock;
    
    boolean[][] visited;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int m = key.length, n = lock.length;

        bottom = new int[m][m];
        left = new int[m][m];
        right = new int[m][m];

        // Left 채우기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                left[m - j - 1][i] = key[i][j];
            }
        }

        // Right 채우기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                right[j][m - 1 - i] = key[i][j];
            }
        }
        
        // Bottom 채우기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                bottom[m - 1 - i][m - 1 - j] = key[i][j];
            }
        }
        
        // lock 확장하기
        int emptyCount = 0; // lock에 존재하는 0의 수(즉, 1로 채워야하는 칸)

        int len = n + 2 * (m - 1);
        
        eLock = new int[len][len];
        visited = new boolean[len][len];
        
        int[] range = { m - 1, m - 1, n + m - 2, n + m - 2 };

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (range[0] <= i && i <= range[2] && range[1] <= j && j <= range[3]) {
                    eLock[i][j] = lock[i - (m - 1)][j - (m - 1)];
                    visited[i][j] = true;
                    if (eLock[i][j] == 0) // 1로 채워야하는 칸의 수
                        emptyCount++;
                } else
                    eLock[i][j] = 0;
            }
        }


        // left 비교
        
        answer = rangeCheck(key, emptyCount) || rangeCheck(left, emptyCount) || rangeCheck(right, emptyCount) || rangeCheck(bottom, emptyCount);
        
        return answer;
    }

    boolean rangeCheck(int[][] rKey, int emptyCount) {
        boolean answer = false;

        int keyLen = rKey.length;

        int elockLen = eLock.length;

        for (int i = 0; i <= elockLen - keyLen; i++) {
            for (int j = 0; j <= elockLen - keyLen; j++) {
                answer = possibleCheck(rKey, emptyCount, i, j);
                if(answer)
                    return true;
            }
        }

        return false;
    }

    boolean possibleCheck(int[][] rKey, int emptyCount, int sx, int sy) {
        boolean answer = false;
        int count = 0;
        int keyLen = rKey.length;
        // sx와 sy가 배열에 존재하는지?
        for (int i = 0; i < keyLen; i++, sx++) {
            int tmp = sy;
            for (int j = 0; j < keyLen; j++, tmp++) {
                if(visited[sx][tmp]) {
                    int sum = eLock[sx][tmp] + rKey[i][j];
                    if(sum == 1) {
                        if(eLock[sx][tmp] == 0) // 자물쇠의 0인 부분을 채우는 경우
                            count++;
                    }else // 0이거나 2이면 false를 반환한다.
                        return false;
                }
            }
        }
    
        if(count == emptyCount)
            return true;

        return answer;
    }

}