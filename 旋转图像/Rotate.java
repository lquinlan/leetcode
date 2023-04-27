public class Rotate {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] a = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        solution.rotate(a);
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }
        int c = matrix.length / 2;
        for (int i = 0; i < c; ++i) {
            for (int j = 0; j < matrix.length - 1 - 2 * i; ++j) {
                int tmp = -11111;
                int f = 0;
                int in1 = i;
                int in2 = i;
                do {
                    if (f == 0) {
                        if (tmp == -11111) {
                            tmp = matrix[in1][in2 + 1];
                            matrix[in1][in2 + 1] = matrix[in1][in2];
                            ++in2;
                        } else {
                            int t = matrix[in1][in2 + 1];
                            matrix[in1][in2 + 1] = tmp;
                            tmp = t;
                            ++in2;
                        }
                        if (in2 == matrix.length - 1 - i) {
                            f = 1;
                        }

                    } else if (f == 1) {
                        if (tmp == -11111) {
                            tmp = matrix[in1 + 1][in2];
                            matrix[in1 + 1][in2] = matrix[in1][in2];
                            ++in1;
                        } else {
                            int t = matrix[in1 + 1][in2];
                            matrix[in1 + 1][in2] = tmp;
                            tmp = t;
                            ++in1;
                        }
                        if (in1 == matrix.length - 1 - i) {
                            f = 2;
                        }

                    } else if (f == 2) {
                        if (tmp == -11111) {
                            tmp = matrix[in1][in2 - 1];
                            matrix[in1][in2 - 1] = matrix[in1][in2];
                            --in2;
                        } else {
                            int t = matrix[in1][in2 - 1];
                            matrix[in1][in2 - 1] = tmp;
                            tmp = t;
                            --in2;
                        }
                        if (in2 == i) {
                            f = 3;
                        }

                    } else if (f == 3) {
                        if (tmp == -11111) {
                            tmp = matrix[in1 - 1][in2];
                            matrix[in1 - 1][in2] = matrix[in1][in2];
                            --in1;
                        } else {
                            int t = matrix[in1 - 1][in2];
                            matrix[in1 - 1][in2] = tmp;
                            tmp = t;
                            --in1;
                        }
                        if (in1 == i) {
                            f = 0;
                        }

                    }

                } while (in1 != i || in2 != i);
            }
        }

    }
}