public class MaxSubArray {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // int i = 0;
        int j = 0;
        int sum = 0;
        int maxsum = -999999;
        while (j < nums.length) {
            if (nums[j] + sum < 0) {
                sum += nums[j];
                maxsum = Math.max(sum, maxsum);
                j = j + 1;
                // i = j + 1;
                sum = 0;
            } else {
                sum += nums[j];
                maxsum = Math.max(sum, maxsum);
                ++j;
            }

        }

        return maxsum;

    }
}