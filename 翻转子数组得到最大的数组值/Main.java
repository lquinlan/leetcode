public class Main {
    public static void main(String[] args) {
        
    }
}
class Solution1 {
    public int maxValueAfterReverse(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.abs(nums[0]-nums[1]);
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            ans+=Math.abs(nums[i]-nums[i+1]);
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int var=0;
                if(i>0&&j<nums.length-1){
                    var=Math.abs(nums[j+1]-nums[i])+Math.abs(nums[j]-nums[i-1])-Math.abs(nums[i]-nums[i-1])-Math.abs(nums[j+1]-nums[j]);

                }else if(i==0&&j<nums.length-1){
                    var=Math.abs(nums[j+1]-nums[i])-Math.abs(nums[j+1]-nums[j]);/*只有j遍历 */
                }else if(i>0&&j==nums.length-1){
                    var=Math.abs(nums[j]-nums[i-1])-Math.abs(nums[i]-nums[i-1]);/*只有i遍历 */
                }
                ans=Math.max(ans,var+ans);
                
            }
        }
        return ans;

    }
}
class Solution {
    public int maxValueAfterReverse(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.abs(nums[0]-nums[1]);
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            ans+=Math.abs(nums[i]-nums[i+1]);
        }
        int var1=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            var1=Math.max(var1,Math.abs(nums[i+1]-nums[0])-Math.abs(nums[i+1]-nums[i]));
        }
        for(int i=1;i<nums.length;i++){
            var1=Math.max(var1,Math.abs(nums[nums.length-1]-nums[i-1])-Math.abs(nums[i]-nums[i-1]));
        }
        // System.out.println(var1);
        int var2=Integer.MIN_VALUE;
        int var3=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int x=nums[i];
            int y=nums[i+1];
            var2=Math.max(var2,Math.min(x,y));
            var3=Math.min(var3,Math.max(x,y));

        }
        // System.out.println(var2+" "+var3);
        return ans+Math.max(var1,2*(var2-var3));

    }
}