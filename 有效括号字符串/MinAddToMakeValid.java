import java.util.Stack;

public class MinAddToMakeValid {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minAddToMakeValid(String s) {

        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
            } else {
                if (stack.size() != 0) {
                    stack.pop();
                } else {
                    ++ans;
                }
            }
        }
        ans += stack.size();

        return ans;

    }
}