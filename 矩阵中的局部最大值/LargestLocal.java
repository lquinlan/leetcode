public class LargestLocal {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] largestLocal(int[][] grid) {
        return conv2d(grid, 3);

    }

    int[][] conv2d(int[][] grid, int size) {
        int[][] result = new int[grid.length - size + 1][grid.length - size + 1];
        int len = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i + size - 1 < len && j + size - 1 < len) {
                    int max = 0;
                    for (int s = i; s < i + size; ++s) {
                        for (int k = j; k < j + size; ++k) {
                            if (max < grid[s][k]) {
                                max = grid[s][k];
                            }
                        }
                    }
                    result[i][j] = max;
                }
            }
        }
        return result;

    }
}