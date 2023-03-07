//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class num3025돌던지기 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    static StringBuilder sb = new StringBuilder();
//    static int R,C,N;
//    static char[][] arr;
//    static ArrayList<Point> point = new ArrayList<>();
//
//
//    static class Point{
//        int col[];
//
//        int r;
//
//        public Point(int[] col, int r) {
//            this.col = col;
//            this.r = r;
//        }
//
//        public void insert(){
//            arr[r-1][col[r-1]]='O';
//        }
//
//        public void trim(){
//
//        }
//    }
//    static ArrayList<ArrayList<Integer>> xIndex;
//    static ArrayList<ArrayList<Integer>> oIndex;
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine());
//        int R = Integer.parseInt(st.nextToken());
//        int C = Integer.parseInt(st.nextToken());
//        arr= new char[R][C];
//        for(int i=0; i<C; i++){
//            xIndex.add(new ArrayList<>());
//            oIndex.add(new ArrayList<>());
//        }
//
//        for(int i=0; i<R; i++){
//            String s = br.readLine();
//            for(int j=0; j<C; j++){
//                arr[i][j] = s.charAt(j);
//                if(arr[i][j]=='X'){
////                    point.add(new Point(i,j,'X'));
//                    xIndex.get(i).add(j);
//                }
//
//            }
//        }
//        N = Integer.parseInt(br.readLine());
//
//        for(int i=0; i<N; i++){
//            int index = Integer.parseInt(br.readLine())-1;
//
//        }
//    }
//    private static int check(int index){
//        if(xIndex.get(index).get(0)>oIndex.get(index)){
//
//        }
//    }
//}
//
//
////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////
////public class ssafy화산탄 {
////
////    public static int R,C,N;
////
////    public static char[][] map;
////
////    public static void main(String[] args) throws IOException{
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringBuilder sb = new StringBuilder();
////
////        String[] str = br.readLine().split(" ");
////
////        R = Integer.parseInt(str[0]);
////        C = Integer.parseInt(str[1]);
////
////        map = new char[R][C];
////
////
////        for(int i =0; i<R; i++) {
////            str = br.readLine().split("");
////            for(int j =0; j<C; j++) {
////                map[i][j] = str[j].charAt(0);
////            }
////        }
////
////        N = Integer.parseInt(br.readLine());
////
////        int start;
////        for(int i =0; i<N; i++) {
////            start = Integer.parseInt(br.readLine());
////
////            stoneBreak(0, start-1);
////            System.out.println("------");
////            for(int k =0; k<R; k++) {
////                for(int j =0; j<C; j++) {
////                    System.out.print(map[k][j]);
////                }
////                System.out.println();
////            }
////            System.out.println("------");
////
////            //if(i == 2)
////            //    break;
////        }
////    }
////
////    static void stoneBreak(int x, int y) {
////
////        while(true) {
////            //System.out.println(x+","+y);
////            if(x+1<R) {
////                if(map[x+1][y] == 'X') { // 장애물을 만난 경우
////                    //System.out.println("장애물을 만남");
////                    map[x][y] = 'O';
////                    break;
////                }else if(map[x+1][y] == 'O') { // 굳은 화산을 만난 경우
////                    //System.out.println("굳은 화산을 만남");
////                    if(0<= y-1 && map[x][y-1] == '.' && map[x+1][y-1] == '.') { // 왼쪽 검사
////                        //System.out.println("L");
////                        x++;
////                        y--;
////                    }else if(y+1 < C && map[x][y+1] == '.' && map[x+1][y+1] == '.') { // 오른쪽 검사
////                        x++;
////                        y++;
////                    }else { // 그 자리에서 굳어버림
////                        map[x][y] = 'O';
////                        break;
////                    }
////                }else {
////                    //System.out.println("평지");
////                    x++;
////                }
////            }else { // 가장 마지막 줄인 경우
////                map[x][y] = 'O';
////                //System.out.println("final");
////                break;
////            }
////        }
////        //System.out.println("END___________________________________--");
////
////        //System.out.println(x+"/"+y);
////    }
////
////}