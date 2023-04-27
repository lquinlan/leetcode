public class FirstMissingPositive {
    public static void main(String[] args) {

    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int fill = nums.length;
        for (int i = 0; i < fill; i++) {
            if (nums[i] < 0) {
                nums[i] = fill;
            }
        }
        for (int i = 0; i < fill; i++) {
            if (Math.abs(nums[i]) < fill && nums[Math.abs(nums[i])] >= 0) {
                nums[Math.abs(nums[i])] *= -1;
            }
        }
        for (int i = 1; i < fill; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return fill;

    }
}