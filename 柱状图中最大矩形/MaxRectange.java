import java.util.Stack;

public class MaxRectange {
    public static void main(String[] args) {

    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int top = 0;
        int p = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {
            if (i == heights.length) {
                p = -1;
            } else {
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