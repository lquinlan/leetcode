public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0];
        dp2[0] = 0;
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i-1]+nums[i], nums[i]);
            dp2[i] = Math.max(dp2[i-1]+nums[i], dp1[i-1]);
            res = Math.max(res, dp1[i]);
            res = Math.max(res, dp2[i]);
        }
        return res;
    }
}