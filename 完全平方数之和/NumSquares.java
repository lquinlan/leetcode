
public class NumSquares {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numSquares(12);

    }
}

// class Solution {
// int cnt = 0;
// // int[] table = new int[100 + 1];
// int[] ans = new int[10000];

// // Solution() {
// // for (int i = 1; i <= 100; ++i) {
// // table[i] = i * i;
// // }
// // }

// int dfs(int n, int ind) {

// if (n == 0) {
// return 0;
// }
// if (ans[n] != 0) {
// return ans[n];
// }

// int ans1 = Integer.MAX_VALUE;
// int nextn = n - ind * ind;
// System.out.println("nextn==" + nextn);
// if (nextn >= 0) {
// ans1 = dfs(nextn, (int) Math.sqrt(nextn)) + 1;
// }
// if ((ind - 1) != 0) {
// ans1 = Math.min(dfs(n, ind - 1), ans1);
// }
// System.out.println("n==" + n);
// System.out.println("ans==" + ans1);
// ans[n] = ans1;
// return ans1;
// }

// public int numSquares(int n) {
// int ind = (int) Math.sqrt(n);
// return dfs(n, ind);

// }
// }

// class Solution {
// public int numSquares(int n) {
// Integer[] map = new Integer[10001];
// return this.f(n, (int) Math.sqrt(n), map);
// }

// private int f(int n, int max, Integer[] map) {
// if (n == 0) {
// return 0;
// }
// if (map[n] != null) {
// return map[n];
// }
// int ans = Integer.MAX_VALUE;
// int nextn = n - max * max;
// System.out.println("nextn==" + nextn);
// if (nextn >= 0) {
// ans = this.f(nextn, (int) Math.sqrt(nextn), map) + 1;
// }
// if (max - 1 != 0) {
// ans = Math.min(ans, this.f(n, max - 1, map));
// }
// map[n] = ans;
// return ans;
// }
// }

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[10000 + 1];
        dp[1] = 1;
        for (int i = 2; i <= 10000; ++i) {
            for (int j = 1; j <= (int) Math.sqrt(i); ++j) {
                dp[i] = Math.min(dp[i], dp[i - j] + 1);
            }

        }
        return dp[n];
    }
}