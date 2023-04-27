public class RemoveDuplicates {
    public static void main(String[] args) {

    }
}

class Solution {
    public int removeDuplicates(int[] nums) {

        int newend = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[newend]) {
                continue;
            } else {
                nums[++newend] = nums[i];

            }
        }
        return newend + 1;
    }
}