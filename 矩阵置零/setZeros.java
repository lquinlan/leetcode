public class setZeros {
    public static void main(String[] args) {

    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        int f1 = -1;
        int f2 = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    if (matrix[i][j] == 0) {
                        f1 = 1;
                    }
                }
                if (j == 0) {
                    if (matrix[i][j] == 0) {
                        f2 = 1;
                    }
                }
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (f1 == 1) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }

        }
        if (f2 == 1) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }

        }

    }
}