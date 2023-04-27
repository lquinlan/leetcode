import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // List<Integer> list = new ArrayList<Integer>();
        int[] list=new int[10001];
        int len=0;
        while (head != null) {
            // list.add(head.val);
            list[len++]=head.val;
            head=head.next;
        }
        // int[] tmp = list.stream().mapToInt(i -> i).toArray();
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        // head=head.next;
        for (int i = 1; i < len; i++) {
            while (!stack.empty() && list[i] > list[stack.peek()]) {
                ans[stack.peek()] = list[i];
                stack.pop();

            }
            stack.push(i);
        }
        // System.out.println("fdf");
        // while (!stack.empty()) {
        //     ans[stack.peek()] = 0;
        //     stack.pop();

        // }

        return ans;

    }
}