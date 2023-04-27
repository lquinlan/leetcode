public class CountBits {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = i & 1 + dp[i >> 1];
        }
        return dp;
    }
}