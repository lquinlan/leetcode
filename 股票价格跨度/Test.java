import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {

    }
}

class StockSpanner {
    int ind = -1;
    Stack<Integer> stack = new Stack<Integer>();
    List<Integer> list = new ArrayList<Integer>();

    public StockSpanner() {
        ind = -1;

    }

    public int next(int price) {
        ++ind;
        while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();

        }
        int res = stack.isEmpty() ? ind + 1 : ind - stack.peek();
        stack.push(ind);
        list.add(price);
        return res;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */