//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class num2931가스관 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    static StringBuilder sb = new StringBuilder();
//    static int R,C;
//    static char[][] input;
//    static int[] dx ={-1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//    static char[] block = {'|', '-', '1', '2', '3', '4'};
//    static int ansr,ansc;
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine());
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//        input = new char[R][C];
//        for(int i=0; i<R; i++){
//            String s= br.readLine();
//            for(int j=0; j<C; j++){
//                input[i][j]=s.charAt(0);
//            }
//        }
//
//
//        for(int i=0;i<R; i++){
//            for(int j=0; j<C; j++){
//                if(input[i][j]=='M'){
//                    for(int k=0; k<4; k++){
//                        int xx = i + dx[k];
//                        int yy = j + dy[k];
//                        if(xx>=0 && xx<R && yy>=0 && yy<C){
//                            dfs(xx,yy,k);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private static void dfs(int i, int j, int dir){
//        if(input[i][j]=='.'){
//
//            for(int a=0; a<block.length; a++){
//                if()
//            }
//        }
//    }
//
//    private static boolean isOpen()
//}
