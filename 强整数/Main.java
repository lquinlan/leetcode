
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        int max_x=0,max_y=0;
        if(x==1){
            max_x=1;
        }else{
            max_x= (int)(Math.log(bound)/Math.log(x));
        }
        if(y==1){
            max_y=1;
        }else{
            max_y= (int)(Math.log(bound)/Math.log(y));
        }
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<=max_x;i++){
            for(int j=0;j<=max_y;j++){
                int tmp=(int)(Math.pow(x,i)+Math.pow(y, j));
                if(tmp<=bound){
                    set.add(tmp);
                }else{
                    break;
                }
            }
        }
        return set.stream().collect(Collectors.toList());
        // return new ArrayList<Integer>(set);

    }
}