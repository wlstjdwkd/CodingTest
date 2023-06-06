import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<nodeinfo.length; i++){
            pq.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }
        
        Node root = pq.poll();
        while(!pq.isEmpty()){
            root.add(pq.poll());
        }
        
        List<Integer> pre = new ArrayList<>();
        preorder(root,pre);
        for (int i = 0; i < pre.size(); i++) {
			answer[0][i] = pre.get(i);
		}
        
        List<Integer> post = new ArrayList<>();
        postorder(root,post);
        for (int i = 0; i < post.size(); i++) {
			answer[1][i] = post.get(i);
		}
        
        return answer;
    }
    
    public void postorder(Node node, List<Integer> post) {
		if (node.left != null)
			postorder(node.left, post);
		if (node.right != null)
			postorder(node.right, post);
		post.add(node.no);
	}

	public void preorder(Node node, List<Integer> pre) {
		pre.add(node.no);
		if (node.left != null)
			preorder(node.left, pre);
		if (node.right != null)
			preorder(node.right, pre);
	}
    
    public class Node implements Comparable<Node>{
        Node left, right;
        int x,y,no;
        public Node(int x, int y, int no){
            this.x=x;
            this.y=y;
            this.no=no;
        }
        public void add(Node node) {
			if (this.x > node.x) {
				if (this.left == null)
					this.left = node;
				else
					this.left.add(node);
			} else {
				if (this.right == null)
					this.right = node;
				else
					this.right.add(node);
			}
		}
        
        @Override
        public int compareTo(Node node){
            if(node.y==this.y){
                return this.x-node.x;
            }
            return node.y-this.y;
        }
    }
}