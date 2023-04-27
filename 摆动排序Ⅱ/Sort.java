import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {

    }
}

class Solution {
    public void wiggleSort(int[] nums) {
        int[] nums1 = new int[nums.length];
        System.arraycopy(nums, 0, nums1, 0, nums.length);
        Arrays.sort(nums1);
        int j = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = nums1[j--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = nums1[j--];
        }

    }
}