public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        int min=nums[0];
        while(l<=r){
            int mid=(l+r)>>1;
            if(nums[mid]>=nums[l]){
                min=Math.min(min,nums[l]);
                l=mid+1;
            }else if(nums[mid]<nums[r]){
                min=Math.min(min,nums[mid]);
                r=mid-1;

            }
        }
        return min;

    }
}
// 3  2

// 5 1 2 3 4