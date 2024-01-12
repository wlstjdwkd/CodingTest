import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위한 BufferedReader
        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력받은 문자열을 공백을 기준으로 나누기 위한 StringTokenizer
        int N = Integer.parseInt(st.nextToken()); // N 입력
        int M = Integer.parseInt(st.nextToken()); // M 입력
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[N*4];
        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1){
                //변경 b->c
                long dif = c-arr[b];
                arr[b] = c;
                update(1, N, 1, b, dif);
            }
            else if(a==2){
                sb.append(sum(1, N, 1, b, (int)c)).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static long init(int start, int end, int node){
        if(start == end){
            return tree[node] = arr[start];
        }
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2) +init(mid+1, end, node*2+1);
    }

    //start, end : 시작 / 끝 인덱스
    //left, right : 구간 합을 구하고자 하는 범위
    public static long sum(int start, int end, int node, int left, int right){
        //범위 밖
        if(left > end || right < start){
            return 0;
        }

        //범위 안
        if(left <= start && end <= right){
            return tree[node];
        }

        //범위에 걸쳐있는 경우
        // 두 부분으로 나누어서 합 구하기
        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    //start, end : 시작 / 끝 인덱스
    //index : 구간 합을 수정하고자 하는 노드
    //dif : 수정할 값
    public static void update(int start, int end, int node, int index, long dif){
        //범위 밖
        if(index < start || index > end){
            return;
        }

        //범위 안
        //노드의 값에 차이만큼 더해준다.
        tree[node] += dif;

        if(start == end){
            return;
        }
        //다른 원소도 갱신

        int mid = (start+end)/2;
        update(start, mid, node*2, index, dif);
        update(mid+1, end, node*2+1, index, dif);
    }
}