public class NextPer {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] p = { 5, 4, 7, 5, 3, 2 };
        solution.nextPermutation(p);
    }
}

// class Solution {
// public void nextPermutation(int[] nums) {
// int i = nums.length - 2;
// while (i >= 0 && nums[i] >= nums[i + 1]) {
// i--;
// }
// if (i >= 0) {
// int j = nums.length - 1;
// while (j >= 0 && nums[i] >= nums[j]) {
// j--;
// }
// swap(nums, i, j); b
// }
// reverse(nums, i + 1);
// }

// public void swap(int[] nums, int i, int j) {
// int temp = nums[i];
// nums[i] = nums[j];
// nums[j] = temp;
// }

// public void reverse(int[] nums, int start) {
// int left = start, right = nums.length - 1;
// while (left < right) {
// swap(nums, left, right);
// left++;
// right--;
// }
// }
// }
class Solution {
    public void nextPermutation(int[] nums) {
        int l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) {
            --l;
        }
        if (l >= 0) {
            int r = nums.length - 1;
            while (r >= 0 && nums[l] >= nums[r]) {
                --r;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        ++l;
        int j = nums.length - 1;
        while (l < j) {
            int tmp = nums[l];
            nums[l] = nums[j];
            nums[j] = tmp;
            ++l;
            --j;
        }

    }
}