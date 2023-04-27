public class FindTargetSumWays {
    public static void main(String[] args) {

    }

}

class Solution {
    int ans = 0;
    int[] presum;

    void dfs(int[] nums, int cursum, int target, int dep) {
        if (dep == nums.length) {
            if (target == cursum) {
                ans++;
            }
            return;
        }
        if (Math.abs(target - cursum) > (presum[presum.length - 1] - presum[dep])) {
            return;
        }
        if ((presum[presum.length - 1] - target) < 0 || (presum[presum.length - 1] - target) % 2 == 1) {
            return;
        }
        int f = -1;
        int tmp = nums[dep];
        for (int i = 0; i < 2; ++i) {

            tmp *= f;
            dfs(nums, cursum + tmp, target, dep + 1);

        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        presum = new int[nums.length + 1];
        presum[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }
        dfs(nums, 0, target, 0);
        return ans;

    }
}