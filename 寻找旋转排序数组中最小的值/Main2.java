public class Main2 {
    
}
// 含有重复元素
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        int l=0,r=nums.length-1;
        int min=nums[0];
        while(l<=r){
            int mid=(l+r)>>1;
            min=Math.min(min,nums[mid]);
            if(nums[mid]==nums[l]&&nums[mid]==nums[r]&&l!=r){
                boolean f=false;
                for(int i=l;i<=r;++i){
                    // mid=(mid+i)%nums.length;
                    if(!(nums[i]==nums[l]&&nums[i]==nums[r])){
                        mid=i;
                        f=true;
                        break;

                    }
                }
                // System.out.println("mid="+mid);
                if(!f){
                    return min;
                }
                
            }
            if(nums[mid]>nums[l]){
                min=Math.min(min,nums[l]);
                l=mid+1;
            }else if(nums[mid]<nums[r]){
                min=Math.min(min,nums[mid]);
                r=mid-1;

            }else if(nums[mid]==nums[l]){
                min=Math.min(min,nums[mid]);
                l=mid+1;

            }else {
                min=Math.min(min,nums[mid]);
                r=mid-1;
            }
            // System.out.println(min);
        }
        return min;

    }
}