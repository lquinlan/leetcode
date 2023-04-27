import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {

    }
}

class Solution {
    List<String> answerList = new ArrayList<String>();
    Set<String> answerSet = new HashSet<String>();
    int[] mask;

    int getnum(String s) {
        Stack<Character> stack = new Stack<Character>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    ++cnt;
                } else {
                    stack.pop();
                }
            }

        }
        cnt += stack.size();
        return cnt;

    }

    String isvalid(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (mask[i] != -1) {
                sb.append(s.charAt(i));
            }
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) <= 'z' && sb.charAt(i) >= 'a') {
                continue;
            }
            if (sb.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return "-1";
                } else {
                    stack.pop();
                }
            }

        }
        if (stack.isEmpty()) {
            return sb.toString();
        } else {
            return "-1";
        }
    }

    void dfs(String s, int n, int ind) {
        if (s.length() - ind < n) {
            return;
        }
        if (n == 0) {
            String tmp = isvalid(s);
            if (tmp.equals("-1")) {
                return;
            } else {
                answerList.add(tmp);
                return;
            }
        }
        if (ind >= s.length()) {
            return;
        }
        for (int i = ind; i < s.length(); ++i) {
            if (s.charAt(i) >= 'z' && s.charAt(i) <= 'a') {
                continue;
            }
            if (i > ind && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            mask[i] = -1;
            dfs(s, n - 1, i + 1);
            mask[i] = 0;
        }

    }

    public List<String> removeInvalidParentheses(String s) {
        int n = getnum(s);
        mask = new int[s.length()];
        dfs(s, n, 0);
        // for (var i : answerSet) {
        // answerList.add(i);
        // }
        if (answerList.size() == 0) {
            answerList.add("");
        }

        return answerList;

    }
}