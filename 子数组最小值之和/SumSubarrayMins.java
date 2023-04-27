import java.util.Stack;

public class SumSubarrayMins {
    public static void main(String[] args) {

    }
}

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] l = new int[len];
        int[] r = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();

            }
            l[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            r[i] = (stack.isEmpty() ? len : stack.peek()) - i;
            stack.push(i);
        }
        long ans = 0;
        final int mod = 1000000007;
        for (int i = 0; i < len; ++i) {
            ans = (ans + (long) l[i] * r[i] * arr[i]) % mod;
        }
        return (int) ans;

    }
}