public class SearchArray {
    public static void main(String[] args) {

    }
}
// 遍历版本
// class Solution {
// public int search(int[] nums, int target) {
// if (nums.length == 0) {
// return 0;
// }
// for (int i = 0; i < nums.length; ++i) {
// if (nums[i] == target) {
// return i;
// }
// }
// return -1;

// }
// }
// 二分版本
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid - 1]) {
                if (nums[l] <= target && nums[mid - 1] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[r - 1] >= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }

            }

        }
        return -1;

    }
}