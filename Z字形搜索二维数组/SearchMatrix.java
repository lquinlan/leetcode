public class SearchMatrix {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length;
        int y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --x;
            } else {
                ++y;
            }

        }
        return false;

    }
}