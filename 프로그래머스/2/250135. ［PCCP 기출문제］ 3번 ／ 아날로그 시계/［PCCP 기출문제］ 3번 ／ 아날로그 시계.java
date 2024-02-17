import java.util.*;

class Solution {
    static class Time {
        int h, m, s;
        
        Time(int h, int m, int s){
            this.h = h;
            this.m = m;
            this.s = s;
        }
        
        Time(int seconds){
            this.h = seconds/3600;
            this.m = (seconds % 3600) / 60;
            this.s = (seconds % 3600) % 60;
        }
        
        int toSeconds(){
            return h * 3600 + m * 60 + s;
        }
        
        List<Double> getDegree(){
            double hDegree = (h%12) * 30d + m*0.5d + s * (1/120d);
            double mDegree = m * 6d + s * (0.1d);
            double sDegree = s * 6d;
            
            return List.of(hDegree, mDegree, sDegree);
        }
    }
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        int start = new Time(h1, m1, s1).toSeconds();
        int end = new Time(h2, m2, s2).toSeconds();
        
        for(int i=start; i<end; i++){
            List<Double> cnt = new Time(i).getDegree();
            List<Double> next = new Time(i+1).getDegree();
            
            boolean hMatch = hourMatch(cnt, next);
            boolean mMatch = minuteMatch(cnt, next);
            
            if(hMatch && mMatch){
                if(Double.compare(next.get(0), next.get(1)) == 0){
                    answer++;
                }
                else{
                    answer += 2;
                }
            }
            else if(hMatch || mMatch){
                answer++;
            }
        }
        
        if(start == 0 || start == 43200){
            answer++;
        }
        
        return answer;
    }
    
    //초침과 시침 겹치는지?
    boolean hourMatch(List<Double> cnt, List<Double> next){
        if(Double.compare(cnt.get(0), cnt.get(2))>0 
            && Double.compare(next.get(0), next.get(2)) <= 0){
            return true;
        }
        
        if(Double.compare(cnt.get(2), 354d) == 0
            && Double.compare(cnt.get(0), 354d) > 0){
            return true;
        }
        
        return false;
    }
    
    //분침과 초침의 겹치는지?
    boolean minuteMatch(List<Double> cnt, List<Double> next){
        if(Double.compare(cnt.get(1), cnt.get(2)) > 0
            && Double.compare(next.get(1), next.get(2)) <= 0){
            return true;
        }
        
        if(Double.compare(cnt.get(2), 354d) == 0 
            && Double.compare(cnt.get(1), 354d) > 0){
            return true;
        }
        
        return false;
    }
}