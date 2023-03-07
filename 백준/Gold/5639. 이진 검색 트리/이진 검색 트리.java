import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Node{
        int value;
        Node left, right;
        Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true){
            String val = br.readLine();
            if(val ==null || val.equals("")){
                break;
            }
            insertNode(root,Integer.parseInt(val));
        }
        postOrder(root);
        System.out.println(sb);

    }
    private static void insertNode(Node temp , int val){
        if(val<temp.value){
            if(temp.left==null){
                temp.left=new Node(val);
            }
            else{
                insertNode(temp.left,val);
            }
        }
        else{
            if(temp.right==null){
                temp.right = new Node(val);
            }
            else{
                insertNode(temp.right,val);
            }
        }
    }
    private static void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append("\n");

    }
}
