public class Main{
    public static void main(String[] args) {
        
    }
}
// 既然使用了滑动窗口其实就没了必要再计算前缀和了
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // int[] presum = new int[nums.length+1];
        // for (int i=0; i<nums.length; i++){
        //     presum[i+1]=presum[i]+nums[i];
        // }
        // if(presum[presum.length-1]<target){
        //     return 0;
        // }
        int l=0,r=0;
        int ans=Integer.MAX_VALUE;
        int temp=0;
        while(l<=r&&r<nums.length){
            
            temp+=nums[r];
           
            while(temp>=target){
                ans=Math.min(ans,r-l+1);
                temp-=nums[l];
                ++l;
                
            }
            ++r;
        }
        return ans==Integer.MAX_VALUE?0:ans;

    }
}