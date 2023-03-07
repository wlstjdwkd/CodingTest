import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class num14225부분수열합 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] input;
    static int[] arr;
    
    static Set<Integer> set = new HashSet<>();
    static int a;
    static boolean[] visit;

    //N과 M(2)같이 풀었음!
    public static void main(String[] args) throws IOException {
        //3
        //5 1 2


        //1 , 2 ,  5
        //3 6 7
        //8

        N = Integer.parseInt(br.readLine());
        input = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        //1 2 5
//        Arrays.sort(input);
        //생각해보니 정렬 안해도 될듯.. 그냥 sum만 구하는거니까


        //조합을 1부터 N개 까지 진행
        for(a=1; a<=N; a++){
            
            arr=new int[a];
            //새로운 조합 수로 시도할 때 마다 visit 배열 초기화 
            Arrays.fill(visit,false);
            dfs(0,0);
        }

        
        int cnt=1;
        while(true){
            //1부터 계속 추가
            //cnt가 set안에 없는 수가 있다면
            if(!set.contains(cnt)){
                //그 cnt를 정답으로 출력
                System.out.println(cnt);
                return;
            }
            cnt++;
        }

    }
    private static void dfs(int depth, int start){
        if(depth==a){
            //depth가 조합 수가 되었을 때 계산
            int sum=0;
            //배열 합
            for(int i=0; i<a; i++){
                sum += arr[i];
            }
            //set을 통해 겹치는 수 추가X
            set.add(sum);
            return;
        }

        for(int i=start; i<N; i++){
            
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = input[i];
                dfs(depth+1,i);
                visit[i]=false;
            }
        }
    }

}
