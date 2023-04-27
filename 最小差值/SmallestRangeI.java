public class SmallestRangeI {
    public static void main(String[] args) {

    }
}

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        // int answer = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (var i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);

        }
        return Math.max(0, max - min - 2 * k);

    }
}