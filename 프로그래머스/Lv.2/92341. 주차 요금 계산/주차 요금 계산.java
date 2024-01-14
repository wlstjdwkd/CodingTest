import java.util.*;
import java.io.*;

class Solution {
    
    public class Machine{
        private int baseTime;
        private int baseFee;
        private int unitTime;
        private int unitFee;
        
        public Machine(int baseTime, int baseFee, int unitTime, int unitFee){
            this.baseTime = baseTime;
            this.baseFee = baseFee;
            this.unitTime = unitTime;
            this.unitFee = unitFee;
        }
        
        public int totalFee(int minute){
            int result = 0;
            if(minute <= baseTime){
                return baseFee;
            }
            
            else{
                result += baseFee;
                minute -= baseTime;
            }
            result += ((int)Math.ceil((float)minute/unitTime) * unitFee);
            
            return result;
        }
    }
    
    public class CarLog{
        private String carId;
        private int enterTime;
        private int leaveTime;
        
        public CarLog(String carId, int enterTime){
            this.carId = carId;
            this.enterTime = enterTime;
            this.leaveTime = 23*60 + 59;
        }
        
        public void updateLeaveTime(int leaveTime){
            this.leaveTime = leaveTime;
        }
        
        public int stayTime(){
            return leaveTime - enterTime;
        }
        
        public String getCarId(){
            return carId;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        Map<String, CarLog> logs = new HashMap<>();
        Map<String, Integer> prices = new TreeMap<>();
        
        Machine parking = new Machine(fees[0], fees[1], fees[2], fees[3]);
        
        for(String record : records){
            String[] tokens = record.split(" ");
            String carId = tokens[1];
            String command = tokens[2];
            
            if("IN".equals(command)){
                logs.put(carId, new CarLog(carId, minute(tokens[0])));
            }
            else{
                CarLog log = logs.get(carId);
                log.updateLeaveTime(minute(tokens[0]));
                prices.put(carId, prices.getOrDefault(carId,0) + log.stayTime());
                logs.remove(carId);
            }
        }
        
        for(CarLog log : logs.values()){
            prices.put(log.getCarId(), prices.getOrDefault(log.getCarId(),0) + log.stayTime());
        }
        
        return prices.values().stream().mapToInt(parking::totalFee).toArray();
    }
    
    private int minute(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3));
        
        return hour * 60 + minute;
    }
}