public class MinPath {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        result[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int m1 = Integer.MAX_VALUE;
                int m2 = m1;
                if (i - 1 >= 0) {
                    m1 = grid[i][j] + result[i - 1][j];
                }
                if (j - 1 >= 0) {
                    m2 = grid[i][j] + result[i][j - 1];
                }
                result[i][j] = Math.min(m1, m2);
            }
        }

        return result[grid.length - 1][grid[0].length - 1];

    }
}