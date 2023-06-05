import java.util.TreeSet;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set=new TreeSet<Long>();
        for(int i=0;i<nums.length;i++){
            
            if(i>k){
                set.remove((long)nums[i-k-1]);
            }
            Long tmp=set.ceiling(((long)nums[i]-(long)t));
            if(tmp!=null&&tmp<=((long)nums[i]+(long)t)){
                return true;
            }
            set.add((long)nums[i]);
            
            
        }
        return false;


    }
}