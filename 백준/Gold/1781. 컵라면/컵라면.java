import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Question[] question;
    static class Question implements Comparable<Question>{
        int deadline, ramen;

        public Question(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Question q){
            if(this.deadline<q.deadline){
                return -1;
            }
            else if(this.deadline==q.deadline){
                if(this.ramen>q.ramen){
                    return -1;
                }
                else if(this.ramen==q.ramen){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else{
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        question = new Question[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            question[i] = new Question(deadline,ramen);
        }

        long nowCnt=0;
        Arrays.sort(question);

        for(Question q: question){
            int size = pq.size();
            if(size<q.deadline){
                pq.offer(q.ramen);
            }
            else if(size == q.deadline){
                int noodleCnt = pq.peek();
                if(noodleCnt<q.ramen){
                    pq.poll();
                    pq.offer(q.ramen);
                }
            }
        }

        while(!pq.isEmpty()){
            nowCnt+=pq.poll();
        }
        System.out.println(nowCnt);

//        map = new HashMap<>();
//        for(int i=0; i<N; i++){
//            st = new StringTokenizer(br.readLine());
//            long key = Long.parseLong(st.nextToken());
//            long value = Long.parseLong(st.nextToken());
//            if(map.containsKey(key)){
//                //이미 있을 때
//                if(map.get(key)<value){
//                    //새로 들어온 값이 더 크면
//                    map.put(key,value);
//                }
//            }
//            else{
//                //없으면 그냥 넣으셈
//                map.put(key,value);
//            }
//        }
//        int sum=0;
//        for(Long key : map.keySet()){
//            sum+=map.get(key);
//        }
//
//        System.out.println(sum);
    }

}