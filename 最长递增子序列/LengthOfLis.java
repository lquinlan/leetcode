public class LengthOfLis {
    public static void main(String[] args) {

    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxnum = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    tmp = Math.max(tmp, dp[j]);
                }

            }
            dp[i] = tmp + 1;
            maxnum = Math.max(maxnum, dp[i]);
        }

        return maxnum;

    }
}