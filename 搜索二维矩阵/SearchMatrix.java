public class SearchMatrix {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][n - 1] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        // System.out.println("l=="+l);
        if (l == -1 || l >= m) {
            return false;
        }
        if (matrix[l][n - 1] == target) {
            return true;
        }

        int l1 = 0;
        int r1 = n - 1;
        while (l1 <= r1) {
            int mid = (l1 + r1) / 2;
            if (matrix[l][mid] < target) {
                l1 = mid + 1;
            } else {
                r1 = mid - 1;
            }

        }
        // System.out.println("l1=="+l1);
        if (l1 == -1 || l1 >= n) {
            return false;
        }
        if (matrix[l][l1] == target) {
            return true;
        }
        return false;

    }
}