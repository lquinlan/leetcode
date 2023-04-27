public class OrderOfLargestPlusSign {
    public static void main(String[] args) {

    }
}

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < mines.length; i++) {
            grid[mines[i][0]][mines[i][1]] = 1;
        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                ans = Math.max(ans, find(grid, x, y, n));
            }
        }
        return ans;

    }

    int find(int[][] grid, int x, int y, int n) {
        if (grid[x][y] == 1) {
            return 0;
        }
        int ans = 1;
        while (true) {
            if (x - ans < 0 || x + ans >= n || y - ans < 0 || y + ans >= n || grid[x - ans][y] == 1
                    || grid[x + ans][y] == 1 || grid[x][y - ans] == 1 || grid[x][y + ans] == 1) {
                break;
            }
            ++ans;

        }

        return ans;

    }
}
