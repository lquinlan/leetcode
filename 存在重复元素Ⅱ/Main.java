import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                var tmp=new ArrayList<Integer>();
                tmp.add(i);
                map.put(nums[i],tmp);
            }
            
        }
        for(var key:map.keySet()){
            var tmp=map.get(key);
            if(tmp.size()<2){
                continue;
            }else{
                for(int i=0;i<tmp.size()-1;++i){
                    if(tmp.get(i+1)-tmp.get(i)<=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}