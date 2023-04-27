import java.util.HashMap;
import java.util.Stack;

public class Valid {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid(")"));
    }
}

class Solution {
    HashMap<Character, Character> map = new HashMap<Character, Character>();

    Solution() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean flag = true;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                if (s.charAt(i) == map.get(stack.peek())) {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else {
                flag = false;
                break;
            }
        }
        // System.out.println(stack.size());
        if (stack.isEmpty() && flag == true) {
            return true;
        } else {
            return false;
        }
    }
}