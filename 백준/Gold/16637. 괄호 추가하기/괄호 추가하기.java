import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] num;
    static char[] op;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        N= Integer.parseInt(br.readLine());
        String s = br.readLine();
        num = new int[N/2 +1];
        op = new char[N/2];
        int j=0;
        int k=0;

        for(int i=0; i<N; i++){
            if(i%2==0){
                num[j++] = s.charAt(i)-'0';
            }
            else{
                op[k++] = s.charAt(i);
            }
        }

        for(int i=0; i<=(N/2 +1)/2; i++){
            boolean[] select = new boolean[N/2+1];
            dfs(select,i,0,1);
        }
        System.out.println(max);

    }
    private static void dfs(boolean[] select, int n,int cnt, int index){
        if(cnt== n){
            int i=1;
            int res=num[0];
            while(i<N/2+1){
                int a=0;
                if(select[i]){
                    switch(op[i]){
                        case '+':
                            a= num[i]+num[i+1];
                            break;
                        case '*':
                            a= num[i]*num[i+1];
                            break;
                        case '-':
                            a= num[i]-num[i+1];
                            break;
                    }
                }
                else{
                    a=num[i];
                }
                switch(op[i-1]){
                    case '+':
                        res+=a;
                        break;
                    case '*':
                        res*=a;
                        break;
                    case '-':
                        res-=a;
                        break;
                }

                if(select[i]){
                    i+=2;
                }
                else{
                    i++;
                }


            }
            max = Math.max(max,res);

            return;
        }
        for(int i=index; i<N/2; i++){
            select[i]=true;
            dfs(select, n,cnt+1,i+2);
            select[i]=false;
        }
    }
}