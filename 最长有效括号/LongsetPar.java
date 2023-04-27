import java.util.Stack;

public class LongsetPar {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("()())"));

    }
}

class Solution {
    public int longestValidParentheses(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int maxl = 0;
        int cur = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        // int len = s.length();
        while (r < s.length()) {
            if (s.charAt(r) == '(') {
                stack.push(r);
                // if (stack.size() * 2 > len) {
                // maxl = maxl > cur ? maxl : cur;
                // cur = 0;
                // stack.pop();
                // }
                // ++r;
            } else if (s.charAt(r) == ')') {
                stack.pop();
                if (stack.empty()) {
                    stack.push(r);
                } else {
                    l = stack.peek();
                    cur = r - l;
                    // ++r;
                }
            }
            // ++r;
            // if (stack.empty()) {
            // len = s.length() - r - 1;
            // System.out.println(len);
            // }
            maxl = Math.max(cur, maxl);
            ++r;
        }
        return Math.max(cur, maxl);
    }
}