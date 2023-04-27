public class PartitionDisjoint {
    public static void main(String[] args) {

    }
}

class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] rightmin = new int[nums.length];
        // rightmin[nums.length - 1] = nums[nums.length - 1];
        int min = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            }
            rightmin[i] = min;
            // System.out.println(min);

        }
        int max = nums[0];
        int ans = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
            if (max <= rightmin[i + 1]) {
                ans = i + 1;
                break;

            }
        }
        return ans;

    }
}