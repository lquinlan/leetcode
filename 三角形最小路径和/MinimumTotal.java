import java.util.List;

public class MinimumTotal {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int N = triangle.size();
        if (N == 1) {
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[N][N];
        int ans = Integer.MAX_VALUE;
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < N; ++i) {
            int L = triangle.get(i).size();
            for (int j = 0; j < L; ++j) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == L - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);

                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                if (i == N - 1) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;

    }
}