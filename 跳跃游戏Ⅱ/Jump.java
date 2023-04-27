public class Jump {
    public static void main(String[] args) {

    }
}

class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int r = 0;
        int end = nums.length - 1;
        int curind = 0;
        while (curind <= end) {
            if (curind + nums[curind] > r) {
                r = curind + nums[curind];
                if (r >= end) {
                    ++ans;
                    break;
                }
            }
            int tmpmax = nums[curind + 1] + curind + 1;
            int tmpind = curind + 1;
            for (int i = curind + 1; i <= r; i++) {
                if (nums[i] + i > tmpmax) {
                    tmpmax = nums[i] + i;
                    tmpind = i;
                }

            }
            if (tmpmax > r) {
                ++ans;
            }
            curind = tmpind;

        }
        return ans;

    }
}