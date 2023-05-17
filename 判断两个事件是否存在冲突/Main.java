import java.time.LocalTime;

public class Main{
    public static void main(String[] args) {
        
    }
}


class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        LocalTime s1=LocalTime.parse(event1[0]);
        LocalTime e1=LocalTime.parse(event1[1]);
        if(s1.isBefore(LocalTime.parse(event2[0]))){
            s1=LocalTime.parse(event2[0]);
        }
        if(e1.isAfter(LocalTime.parse(event2[1]))){
            e1=LocalTime.parse(event2[1]);
        }
        return s1.isBefore(e1)||s1.equals(e1);
      
    }
}