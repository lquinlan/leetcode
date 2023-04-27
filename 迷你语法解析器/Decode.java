import java.util.List;
import java.util.Stack;

public class Decode {
    public static void main(String[] args) {

    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger();

    // Constructor initializes a single integer.
    public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class Solution {
    int i = 0;

    public NestedInteger deserialize(String s) {
        NestedInteger ni = new NestedInteger();
        if (s.length() == 0) {
            return ni;
        }
        if (s.charAt(0) != '[') {
            ni.setInteger(Integer.parseInt(s));
            return ni;
        }
        if (s.length() <= 2) {
            return ni;
        }

        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(i++));
        int f = 1;
        while (!stack.isEmpty()) {
            int tmp = Integer.MIN_VALUE;
            if (s.charAt(i) == '-') {
                f = -1;
                ++i;

            }
            while (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                tmp = tmp * 10 + (s.charAt(i) - '0');
                ++i;

            }
            // System.out.println("tmp=="+tmp);
            if (tmp != Integer.MIN_VALUE) {
                ni.add(new NestedInteger(tmp * f));
                f = 1;
            }

            if (s.charAt(i) == ',') {
                ++i;
                continue;
            }
            if (s.charAt(i) == '[') {
                NestedInteger tni = deserialize(s);
                ni.add(tni);
            }
            if (s.charAt(i) == ']') {
                stack.pop();
            }
            ++i;

        }
        return ni;

    }
}