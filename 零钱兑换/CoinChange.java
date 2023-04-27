// import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[] { 1, 2, 5 };
        int ans = solution.coinChange(coins, 11);
        System.out.println(ans);

    }
}

class Solution {
    int[] dp = new int[10002];
    int min = Integer.MAX_VALUE;

    int dfs(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            int tmp = dfs(coins, amount - coins[i]) + 1;

            if (tmp != 0) {
                ans = Math.min(tmp, ans);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        dp[amount] = ans;
        return ans;

    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // Arrays.sort(coins);
        return dfs(coins, amount);

    }
}