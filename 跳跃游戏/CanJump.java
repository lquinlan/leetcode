public class CanJump {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canJump(int[] nums) {
        boolean result = false;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                if (i + nums[i] > max) {
                    max = i + nums[i];
                }
            }

        }
        if (max > nums.length - 1) {
            result = true;
        }

        return result;

    }
}