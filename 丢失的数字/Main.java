public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;++i){
            ans^=nums[i]^i;
        }
        if(ans==0){
            return nums.length;
        }else{
            ans^=nums.length;
            return ans;
        }

    }
}