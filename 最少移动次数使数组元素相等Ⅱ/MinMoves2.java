
import java.util.Arrays;

public class MinMoves2 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int mid = 0;
        if ((nums.length & 1) != 0) {
            mid = nums[nums.length / 2];

        } else {
            mid = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        }
        int ans = 0;
        for (var i : nums) {
            ans += Math.abs(i - mid);

        }
        return ans;

    }
}