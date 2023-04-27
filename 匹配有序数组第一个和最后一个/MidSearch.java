public class MidSearch {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        if (nums.length == 1) {
            if (target == nums[0]) {
                return new int[] { 0, 0 };
            } else {
                return new int[] { -1, -1 };
            }
        }
        int l = 0;
        int r = nums.length;
        int ans1 = -1;
        int ans2 = -1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                ans1 = mid;
                r = mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                ans2 = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return new int[] { ans1, ans2 };

    }
}