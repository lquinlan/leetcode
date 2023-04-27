import java.util.Stack;

public class MaxRectange {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] m = new char[][] { { '1', '0' }, { '1', '0' } };
        solution.maximalRectangle(m);
    }
}

// 预处理+暴力枚举

// class Solution {
// public int maximalRectangle(char[][] matrix) {
// int[][] left = new int[matrix.length][matrix[0].length];
// for (int i = 0; i < matrix.length; i++) {
// for (int j = 0; j < matrix[i].length; j++) {
// if (matrix[i][j] == '1') {
// left[i][j] = left[i - 1][j] + 1;
// } else {
// left[i][j] = 0;
// }
// }
// }
// int res = 0;
// for (int i = 0; i < left.length; i++) {
// for (int j = 0; j < left[i].length; j++) {
// int curmin = left[i][j];
// // res=curmin;
// for (int k = i; k >= 0; --k) {
// curmin = Math.min(curmin, left[k][j]);
// res = Math.max(res, curmin * (i - k + 1));
// }
// }
// }
// return res;

// }
// }

// 将问题转化为上个问题的多一维
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;

                } else {
                    height[j] = 0;
                }
            }
            System.arraycopy(height, 0, heights, 0, height.length);
            res = Math.max(res, largestRectangleArea(heights));
            // System.out.println("res=" + res);
        }
        return res;
    }

    int largestRectangleArea(int[] heights) {
        int res = 0;
        int top = 0;
        int p = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {

            if (i == heights.length) {
                p = -1;
            } else {
                // System.out.println(heights[i]);
                p = heights[i];
            }
            if (stack.empty() || heights[stack.peek()] <= p) {
                stack.push(i);
            } else {
                while (!stack.empty() && heights[stack.peek()] > p) {
                    top = stack.pop();
                    int tmp = (i - top) * heights[top];
                    res = res > tmp ? res : tmp;
                }
                stack.push(top);
                heights[top] = p;
            }
        }

        return res;

    }
}