import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

    }
}

class Solution {
    class Pair<T, E> {
        T first;
        E second;

        Pair(T first, E second) {
            this.first = first;
            this.second = second;
        }
    }

    Pair<Integer, Integer> getnum(int ind, String s) {
        int nums = 0;
        while (s.charAt(ind) <= '9' && s.charAt(ind) >= '0') {
            nums = nums * 10 + (s.charAt(ind) - '0');
            ++ind;
        }
        return new Pair<Integer, Integer>(nums, ind);
    }

    Pair<Integer, String> build(int c, int ind, String s) {
        // ++ind;
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        stack.push(s.charAt(ind++));
        while (!stack.isEmpty()) {
            if (s.charAt(ind) >= 'a' && s.charAt(ind) <= 'z') {
                sb.append(s.charAt(ind));
                ++ind;
            } else if (s.charAt(ind) == ']') {
                stack.pop();
                ++ind;

            } else {
                Pair<Integer, Integer> nums = getnum(ind, s);
                Pair<Integer, String> tmp = build(nums.first, nums.second, s);
                sb.append(tmp.second);
                ind = tmp.first;
            }

        }
        // sb.repeat(ind-1);
        String tmps = sb.toString();
        tmps.repeat(c - 1);
        // for (int i = 1; i < c; ++i) {
        // sb.append(tmps);
        // }
        return new Pair<Integer, String>(ind, tmps);

    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
                ++i;
            } else {

                Pair<Integer, Integer> nums = getnum(i, s);
                Pair<Integer, String> tmp = build(nums.first, nums.second, s);
                sb.append(tmp.second);
                i = tmp.first;

            }
        }
        return sb.toString();

    }
}