import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1967트리지름 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static class Node{
        int num;
        int weight;
        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
    }
}
