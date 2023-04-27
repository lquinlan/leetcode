public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0;
        int ans = 0;
        int mul = 1;
        while (l < nums.length && r < nums.length) {
            mul *= nums[r];
            if (mul < k) {
                ans += (r - l + 1);
                ++r;
            } else {
                mul /= nums[l];
                mul /= nums[r];
                l++;
            }

        }
        return ans;

    }
}