public class Rob {
    public static void main(String[] args) {

    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        int[] curmax = new int[nums.length];
        curmax[0] = nums[0];
        curmax[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            curmax[i] = Math.max(curmax[i - 2] + nums[i], curmax[i - 1]);
        }
        return curmax[curmax.length - 1];
    }
}