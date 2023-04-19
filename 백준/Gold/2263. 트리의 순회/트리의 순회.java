import java.util.*;    
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
class Solution{
    int n;
    int inOrder[],postOrder[],position[];
    public Solution() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        inOrder = new int[n+1];
        postOrder = new int[n+1];
        position = new int[n+1];
        for(int i=0;i<n;i++) {
            inOrder[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++) {
            postOrder[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++) {
            position[inOrder[i]] = i; // 인오더에서 루트의 위치를 저장해주는 인덱스배열
        }
        solve(0,n-1,0,n-1);
    }
    public void solve(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return;
        int root = postOrder[postEnd]; // 포스트오더의 끝부분이 루트이다
        System.out.print(root+" ");
        int p = position[root];
        solve(inStart, p-1, postStart, postStart+(p-inStart)-1); // 왼쪽탐색
        solve(p+1,inEnd,postStart+(p-inStart),postEnd-1); // 오른쪽탐색
    }
}