import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int stoi(String s){
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {
        Q = stoi(br.readLine());
        while(Q-- >0){
            st = new StringTokenizer(br.readLine());
            if(stoi(st.nextToken()) == 1){
                name = st.nextToken();
                k = stoi(st.nextToken());

                if(!info.containsKey(name)){
                    info.put(name, new PriorityQueue<>(Collections.reverseOrder()));
                }

                PriorityQueue<Integer> pq = info.get(name);
                for(int j=0; j<k; j++){
                    pq.add(stoi(st.nextToken()));
                }
            }
            else{
                name = st.nextToken();
                if(!info.containsKey(name)){
                    continue;
                }

                b = stoi(st.nextToken());

                PriorityQueue<Integer> pq = info.get(name);

                for(int j=0; j<b && !pq.isEmpty(); j++){
                    totalCost += pq.poll();
                }

            }
        }
        System.out.println(totalCost);
    }

    static int Q, k, b;
    static long totalCost = 0L;
    static String name;
    static Map<String, PriorityQueue<Integer>> info = new HashMap<>();

}