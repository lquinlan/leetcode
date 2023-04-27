public class MaxMulSubArray {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int maxmul = nums[0];
        int a = 1;
        for (int i : nums) {
            a *= i;
            if (a > maxmul) {
                maxmul = a;
            }
            if (i == 0) {
                a = 1;
            }
        }
        a = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            a *= nums[i];
            if (a > maxmul) {
                maxmul = a;
            }
            if (nums[i] == 0) {
                a = 1;
            }
        }
        return maxmul;

    }
}
