public class MaxRotateFunction {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxRotateFunction(int[] nums) {
        int max = 0;
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += i * nums[i];
            sum += nums[i];
        }

        max = tmp;
        for (int i = 1; i < nums.length; i++) {
            // System.out.println("i=="+i);
            tmp = tmp - sum + nums[i - 1] * nums.length;
            max = Math.max(max, tmp);
            // System.out.println("max=="+max);
        }
        return max;

    }
}