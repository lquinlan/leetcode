import java.util.Stack;

public class MinStackMain {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
// 采用辅助栈
// class MinStack {
// Stack<Integer> stack = new Stack<Integer>();
// Stack<Integer> minstack = new Stack<Integer>();

// public MinStack() {
// minstack.push(Integer.MAX_VALUE);
// }

// public void push(int val) {
// stack.push(val);
// minstack.push(Math.min(val, minstack.peek()));

// }

// public void pop() {
// stack.pop();
// minstack.pop();

// }

// public int top() {
// return stack.peek();

// }

// public int getMin() {
// return minstack.peek();

// }
// }

// 常数辅助空间

class MinStack {
    Stack<Long> stack = new Stack<Long>();
    // Stack<Integer> minstack = new Stack<Integer>();
    long minVal;

    public MinStack() {
        // minstack.push(0);
        // stack.push(0L);

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            minVal = val;
        } else {
            long diff = val - minVal;
            if (diff < 0) {
                minVal = val;
                stack.push(diff);
            } else {
                stack.push(diff);
            }
        }
        // minstack.push(Math.min(val, minstack.peek()));

    }

    public void pop() {
        long diff = stack.peek();
        if (diff < 0) {
            stack.pop();
            minVal -= diff;
        } else {
            stack.pop();
        }

    }

    public int top() {
        long diff = stack.peek();
        if (diff < 0) {
            return (int) minVal;
        } else {
            return (int) (minVal + diff);
        }

    }

    public int getMin() {
        // return minstack.peek();
        return (int) minVal;

    }
}