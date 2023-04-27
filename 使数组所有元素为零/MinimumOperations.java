public class MinimumOperations {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumOperations(int[] nums) {
        int[] vis = new int[101];
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0 && vis[nums[i]] != 1) {
                vis[nums[i]] = 1;
                ++cnt;
            }
        }
        return cnt;

    }
}