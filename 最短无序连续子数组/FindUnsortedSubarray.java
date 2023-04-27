public class FindUnsortedSubarray {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = nums[nums.length - 1];
        int max = nums[0];
        int low = 0;
        int high = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                high = i;
            } else {
                max = nums[i];
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            } else {
                low = i;
            }
        }
        if (low == high) {
            return 0;
        }
        return high - low + 1;

    }
}