public class MissingTwo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] missingTwo(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans = ans ^ i;
        }
        for (int i = 1; i <= nums.length + 2; ++i) {
            ans = ans ^ i;
        }
        int lowbit = ans & (-ans);
        int y = 0;
        for (int i : nums) {
            if ((i & lowbit) != 0) {
                y = y ^ i;
            }
        }
        for (int i = 1; i <= nums.length + 2; ++i) {
            if ((i & lowbit) != 0) {
                y = y ^ i;
            }

        }
        int[] newAnswer = new int[2];
        newAnswer[0] = y;
        newAnswer[1] = y ^ ans;
        return newAnswer;

    }
}
