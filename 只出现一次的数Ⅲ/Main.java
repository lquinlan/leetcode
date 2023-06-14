public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length==2){
            return nums;
        }
        int ans=0;
        for(var i:nums){
            ans^=i;
        }
        ans&=-ans;
        int[] res=new int[2];
        for(var i:nums){
            if((i&ans)==0){
                res[0]^=i;
            }else{
                res[1]^=i;
            }
        }
        return res;

    }
}
