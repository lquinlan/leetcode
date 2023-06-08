import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            return new ArrayList<String>();
        }
        if(nums.length==1){
            return List.of(nums[0]+"");
        }
        List<String> res=new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        // sb,append(nums)
        sb.append(nums[0]);
        int l=0;
        int i=1;
        while(i<nums.length){
            while(i<nums.length&&nums[i]==nums[i-1]+1){
                ++i;
            }

            if(i-1!=l){
                sb.append("->");
                sb.append(nums[i-1]);
            }
            res.add(sb.toString());
            sb.delete(0, sb.length());
            if(i>=nums.length){
                break;
            }
            sb.append(nums[i]);
            l=i;
            ++i;
        }
        if(sb.length()>0){
             res.add(sb.toString());
        }
        return res;

    }
}