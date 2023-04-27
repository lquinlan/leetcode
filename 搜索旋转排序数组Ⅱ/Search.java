public class Search {
    public static void main(String[] args) {
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target ? true : false;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            while (l < r && nums[l] == nums[l + 1])
                ++l;
            while (l < r && nums[r] == nums[r - 1])
                --r;
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && nums[mid] >= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            }

        }
        return false;

    }
}