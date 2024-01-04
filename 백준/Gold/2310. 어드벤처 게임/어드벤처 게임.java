import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Room{
        String roomType;
        int amount;
        ArrayList<Integer> canGo;
        boolean visit;
        public Room(String roomType, int amount, ArrayList<Integer> canGo){
            this.roomType = roomType;
            this.amount = amount;
            this.canGo = canGo;
            this.visit = false;
        }
    }
    static boolean result;
    static int n;
    static Room[] rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        while(true){
            result = false;
            n= Integer.parseInt(br.readLine());
            if(n==0){
                break;
            }
            rooms = new Room[n];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String roomType = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());
                ArrayList<Integer> canGo = new ArrayList<>();
                while(st.hasMoreTokens()){
                    canGo.add(Integer.parseInt(st.nextToken()));
                }
                canGo.remove(canGo.size()-1);
                rooms[i] = new Room(roomType, amount, canGo);
            }
            move(0, 0);
            if(!result){
                System.out.println("No");
            }
        }


    }
    private static void move(int start, int money){
        if(rooms[start].roomType.equals("T")){
            //트롤만나면
            money -= rooms[start].amount;
        }
        else{
            //레프나 문 만나면
            if(money < rooms[start].amount){
                money = rooms[start].amount;
            }
        }

        if(money>=0){
            if(start + 1 == n){
                System.out.println("Yes");
                result = true;
            }
            rooms[start].visit = true;

            for(int i=0; i<rooms[start].canGo.size(); i++){
                int next = rooms[start].canGo.get(i)-1;
                if(!rooms[next].visit){
                    move(next, money);
                }
            }
            rooms[start].visit = false;

        }

//        else{
//            if(rooms[start].roomType.equals("T")){
//                money += rooms[start].amount;
//
//            }
//            return;
//        }
    }
}