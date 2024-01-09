import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, new Comparator<String>(){
           public int compare(String s1, String s2){
               String head1 = s1.split("[0-9]")[0];
               String head2 = s2.split("[0-9]")[0];
               
               s1=s1.replace(head1,"");
               s2=s2.replace(head2,"");
               
               head1=head1.toLowerCase();
               head2=head2.toLowerCase();
               
               int headCompareValue = head1.compareTo(head2);
               if(headCompareValue == 0){
                   String num1 = "";
                   for(char c : s1.toCharArray()){
                       if(!(c>='0' && c<='9')){
                           break;
                       }
                       num1+=c;
                   }
                   
                   String num2 = "";
                   for(char c : s2.toCharArray()){
                       if(!(c>='0' && c<='9')){
                           break;
                       }
                       num2+=c;
                   }
                   return (Integer.parseInt(num1) - Integer.parseInt(num2));
               } else{
                   return headCompareValue;
               }
           } 
        });
        
        return files;
    }
}