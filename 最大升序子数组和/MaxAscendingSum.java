public class MaxAscendingSum {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int i = 0;
        int tmp = nums[i];
        while (i + 1 < nums.length) {
            if (nums[i + 1] > nums[i]) {
                tmp += nums[i + 1];
                ans = Math.max(ans, tmp);
            } else {
                tmp = nums[i + 1];
            }
            ++i;

        }
        return ans;

    }
}