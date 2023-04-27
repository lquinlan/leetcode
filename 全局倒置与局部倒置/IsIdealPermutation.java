public class IsIdealPermutation {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;

    }
}
