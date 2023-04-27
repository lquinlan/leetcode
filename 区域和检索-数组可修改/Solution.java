public class Solution {
    public static void main(String[] args) {

    }
}

class NumArray {
    int[] nums;
    int[] sums;
    int size;

    public NumArray(int[] nums) {
        this.nums = nums;
        size = (int) Math.sqrt(nums.length);
        sums = new int[(int) Math.ceil(nums.length / size)];

    }

    public void update(int index, int val) {
        // nums[index] = val;
        sums[index / size] = val - nums[index];
        nums[index] = val;

    }

    public int sumRange(int left, int right) {
        int b1 = left / size, b2 = right / size;
        int i = left % size, j = right % size;
        int sum = 0;
        if (b1 == b2) {
            for (; left <= right; ++left) {
                sum += nums[left];
            }
            return sum;
        }
        int sum1 = 0;
        for (; i < size; ++i) {
            sum1 += nums[b1 * size + i];
        }
        int sum2 = 0;
        for (int k = b1 + 1; k < b2; ++k) {
            sum2 += sums[k];
        }
        int sum3 = 0;
        for (int k = 0; k <= j; ++k) {
            sum3 += nums[b2 * size + k];
        }

        return sum1 + sum2 + sum3;

    }
}
