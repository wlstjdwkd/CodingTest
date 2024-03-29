import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    
    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static int N;
        static ArrayList<ArrayList<Integer>> list;
        static int[] people;
        static boolean[] visit;
        static boolean[] select;
        static int min = Integer.MAX_VALUE;
        public static void main(String[] args) throws IOException {
            N = Integer.parseInt(br.readLine());
            people = new int[N];
            select= new boolean[N];
            visit = new boolean[N];
            st = new StringTokenizer(br.readLine());
    
            list = new ArrayList<>();
            for(int i=0;i<N; i++){
                list.add(new ArrayList<>());
                people[i]=Integer.parseInt(st.nextToken());
            }
    
            for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine());
                int cnt = Integer.parseInt(st.nextToken());
                for(int j=0; j<cnt; j++){
                    list.get(i).add(Integer.parseInt(st.nextToken())-1);
                }
            }
            dfs(0);
            if(min == Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else{
                System.out.println(min);
            }
        }
        private static void dfs(int cnt){
            if(cnt==N){
                List<Integer>alist = new ArrayList<>();
                List<Integer>blist = new ArrayList<>();
    
                for(int i =0; i<N; i++){
                    if(!select[i]){
                        alist.add(i);
                    }
                    else{
                        blist.add(i);
                    }
    
                }
                if(alist.size()==0 || blist.size()==0){
                    return;
                }
                if(check(alist) && check(blist)){
                    getPersonDiff();
                }
                return;
    
            }
    
            select[cnt]=true;
            dfs(cnt+1);
            select[cnt]=false;
            dfs(cnt+1);
        }
        private static boolean check(List<Integer> lst){
            Queue<Integer> q = new ArrayDeque<>();
            visit = new boolean[N];
            visit[lst.get(0)]=true;
            q.add(lst.get(0));
            int cnt=1;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int i=0; i<list.get(cur).size(); i++){
                    int y = list.get(cur).get(i);
                    if(lst.contains(y) && !visit[y]){
                        q.add(y);
                        visit[y]=true;
                        cnt++;
                    }
    
                }
            }
            if(cnt == lst.size()){
                return true;
            }
            else{
                return false;
            }
        }
        private static void getPersonDiff(){
            int sel=0;
            int notSel=0;
            for(int i=0; i<N;i++){
                if(select[i]){
                    sel+=people[i];
                }
                else{
                    notSel+=people[i];
                }
            }
            int abs = Math.abs(sel-notSel);
            min = Math.min(abs,min);
        }
    
    
    }