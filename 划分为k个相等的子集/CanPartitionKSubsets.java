import java.util.Arrays;
import java.util.Collections;

public class CanPartitionKSubsets {
    public static void main(String[] args) {
        int[] nums = { 3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2

        };
        Solution solution = new Solution();
        long s = System.currentTimeMillis();
        System.out.println(solution.canPartitionKSubsets(nums, 6));
        long e = System.currentTimeMillis();
        System.out.println(e - s);

    }
}

class Solution {
    int[] vis = new int[16];

    boolean check(int[] nums, int[] set, int ind) {
        if (ind < 0) {
            return true;
        }
        for (int i = 0; i < set.length; i++) {
            if (i != 0 && set[i] == set[i - 1])
                continue;
            if (set[i] - nums[ind] >= 0) {
                set[i] -= nums[ind];
                if (check(nums, set, ind - 1)) {
                    return true;
                } else {
                    set[i] += nums[ind];
                }
            }

        }
        return false;

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == nums.length && nums.length > 4)
            return false;
        int cap = 0;
        int sum = 0;
        for (int i : nums) {
            sum += i;

        }
        if (sum % k != 0) {
            return false;
        }
        cap = sum / k;

        int[] set = new int[k];
        for (int i = 0; i < k; i++) {
            set[i] = cap;
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] > cap) {
            return false;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return check(nums, set, nums.length - 1);
    }
}