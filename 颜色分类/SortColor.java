public class SortColor {
    public static void main(String[] args) {

    }
}

class Solution {
    public void sortColors(int[] nums) {
        int a0 = 0;
        int a1 = 0;
        for (var i : nums) {
            if (i == 0) {
                ++a0;
            } else if (i == 1) {
                ++a1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (a0 != 0) {
                nums[i] = 0;
                --a0;
            } else if (a1 != 0) {
                nums[i] = 1;
                --a1;
            } else {
                nums[i] = 2;
            }
        }
    }
}