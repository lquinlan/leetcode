public class MajorityElection {
    public static void main(String[] args) {

    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int cursum = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                cursum = 1;
                cursum = nums[i];
            } else if (nums[i] == cursum) {
                ++count;
            } else {
                --count;
            }
        }
        return cursum;

    }
}