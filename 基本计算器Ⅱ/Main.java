import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.calculate("(3+2)*2");

    }
}

class Solution {
    Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();

    Solution() {
        map.put("+", (s1, s2) -> s1 + s2);
        map.put("-", (s1, s2) -> s2 - s1);
        map.put("*", (s1, s2) -> s1 * s2);
        map.put("/", (s1, s2) -> s2 / s1);
    }

    public int calculate(String s) {
        var tokens = process(s);
        System.out.println(tokens.toString());
        for (var token : tokens) {
            if (map.containsKey(token)) {
                stack.push(map.get(token).apply(stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();

    }

    List<String> process(String s) {
        s = s.replace(" ", "");
        // StringBuilder sb=new StringBuilder();
        List<String> l = new ArrayList<String>();
        Stack<Character> stack = new Stack<>();
        var chars = s.toCharArray();
        // int tmp = 0;
        boolean isnum = false;
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb=new StringBuilder();
            while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                isnum = true;
                sb.append(chars[i]);
                ++i;
            }
           
            if (isnum) {
                l.add(new String(sb));
                isnum = false;
                // tmp = 0;
            }
            if(i>=chars.length){
                break;
            }
            while (!stack.isEmpty() && (stack.peek()!='('&&getpority(stack.peek()) >= getpority(chars[i]))) {
                if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                l.add(String.valueOf(stack.pop()) );
            }
            if (chars[i] != ')') {
                stack.add(chars[i]);
            }

        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                stack.pop();
                continue;
            }
            l.add(String.valueOf(stack.pop()) );
        }
        return l;
    }

    int getpority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else if (op == '(') {
            return 3;
        } else {
            return 0;
        }
    }
}