public class CanPartition {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (var i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % 2 != 0) {
            return false;
        }
        if (max > sum / 2) {
            return false;
        }
        if (max == sum / 2) {
            return true;
        }
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; ++i) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < dp.length; ++i) {
            int tmp = nums[i];
            for (int j = 1; j < dp[i].length; ++j) {
                if (j >= tmp) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - tmp];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[nums.length][sum / 2];

    }
}