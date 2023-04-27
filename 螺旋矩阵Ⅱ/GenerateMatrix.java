public class GenerateMatrix {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int N = matrix.length * matrix[0].length;
        int l1 = 0, l2 = matrix[0].length, l3 = matrix.length, l4 = -1;
        int i = 0, j = 0;
        int cnt = 1;
        int f = 1;
        // List<Integer> answer = new ArrayList<Integer>();
        while (cnt <= N) {
            if (f == 1) {
                matrix[i][j] = cnt;
                ;
                ++cnt;
                ++j;
                if (j == l2) {
                    f = 2;
                    --l2;
                    ++i;
                    --j;
                }

            } else if (f == 2) {
                matrix[i][j] = cnt;
                ;
                ++cnt;
                ++i;
                if (i == l3) {
                    f = 3;
                    --i;
                    --j;
                    --l3;
                }
            } else if (f == 3) {
                matrix[i][j] = cnt;
                ;
                ++cnt;
                --j;
                if (j == l4) {
                    ++l4;
                    ++j;
                    --i;
                    f = 4;
                }
            } else if (f == 4) {
                matrix[i][j] = cnt;
                ;
                ++cnt;
                --i;
                if (i == l1) {
                    ++l1;
                    ++i;
                    ++j;
                    f = 1;
                }
            }
        }
        return matrix;

    }
}