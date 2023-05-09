
import java.time.LocalTime;


public class Main {
    public static void main(String[] args) {
        LocalTime dt1 = LocalTime.parse("25:59");
        LocalTime dt2 = LocalTime.of(00, 00);
        System.out.println(dt1 + " " + dt2);
        System.out.println(dt1.isAfter(dt2));

    }

}

class Solution {
    LocalTime dt1 = LocalTime.now();
    int ans=0;

    void dfs(char[] time,int ind){
        if(time.length==ind){
            try{
                dt1 = LocalTime.parse(time.toString());
                // System.out.println(dt1);
                ++ans;
            }catch(Exception e){

            }
            return;
        }
        if(time[ind]=='?'){
            for(int i=0;i<10;i++){
                time[ind]=(char)('0'+i);
                
                dfs(time,ind+1);
                time[ind]='?';
            }
        }else{
            dfs(time,ind+1);
        }

    }
    public int countTime(String time) {

       dfs(time.toCharArray(),0);
       
        return ans;

    }
}