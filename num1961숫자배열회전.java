import java.util.*;

public class num1961숫자배열회전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[N - j - 1][i]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[N - i - 1][N - j - 1]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[j][N - i - 1]);
                }
                System.out.println();
            }
        }
    }
}
