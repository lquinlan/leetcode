public class MaxSquare {
    public static void main(String[] args) {

    }
}

class Solution {
    int getsquare(char[][] matrix, int x, int y) {
        // int i = x;
        // int j = y;
        if (matrix[x][y] == '0') {
            return 0;
        }
        int cursquare = 1;
        int l = Math.min(matrix.length, matrix[0].length);
        for (int i = 1; i < l; i++) {
            for (int j = y; j <= (y + i); ++j) {
                if ((x + i) >= matrix.length || j >= matrix[0].length) {
                    return cursquare;

                }
                if (matrix[x + i][j] == '0') {
                    return cursquare;
                }
            }
            for (int j = x; j <= (x + i); ++j) {
                if ((j) >= matrix.length || (y + i) >= matrix[0].length) {
                    return cursquare;

                }
                if (matrix[j][y + i] == '0') {
                    return cursquare;
                }
            }

            cursquare = (i + 1) * (i + 1);

        }
        return cursquare;

    }

    public int maximalSquare(char[][] matrix) {
        int maxsquare = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int cursquare = getsquare(matrix, i, j);
                maxsquare = Math.max(maxsquare, cursquare);
            }
        }

        return maxsquare;

    }
}