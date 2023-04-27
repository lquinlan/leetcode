public class RemoveDuplictes {
    public static void main(String[] args) {

    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int f = 0;
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[l] && f == 0) {
                f = 1;
                nums[++l] = nums[i];
            } else if (nums[i] != nums[l]) {
                nums[++l] = nums[i];
                f = 0;

            }
        }
        return l + 1;

    }
}