public class FindDuplicate {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        int ans = -1;
        while (l < r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                cnt += (nums[i] <= mid) ? 1 : 0;

            }
            if (cnt <= mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}