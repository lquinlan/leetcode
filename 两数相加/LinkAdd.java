import java.util.LinkedList;
import java.util.Queue;

public class LinkAdd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        // ListNode l11 = new ListNode(4);
        // ListNode l12 = new ListNode(3);
        // l1.next = l11;
        // l11.next = l12;
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        ListNode l25 = new ListNode(9);
        ListNode l26 = new ListNode(9);
        ListNode l27 = new ListNode(9);
        ListNode l28 = new ListNode(9);
        ListNode l29 = new ListNode(9);

        l2.next = l21;
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;
        l27.next = l28;
        l28.next = l29;
        Solution solution = new Solution();
        ListNode ans = solution.addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * i val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode() {
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> num1 = new LinkedList<Integer>();
        Queue<Integer> num2 = new LinkedList<Integer>();
        // System.out.println("1");
        while (l1 != null) {
            num1.add(l1.val);
            l1 = l1.next;
        }
        // System.out.println("2");
        while (l2 != null) {
            num2.add(l2.val);
            l2 = l2.next;
        }
        // System.out.println("3");
        int val1 = 0;
        int val2 = 0;
        int j = 0;
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode last = null;
        while (!num1.isEmpty() || !num2.isEmpty()) {
            if (!num1.isEmpty()) {
                val1 = num1.poll();
            } else {
                val1 = 0;
            }
            if (!num2.isEmpty()) {
                val2 = num2.poll();
            } else {
                val2 = 0;
            }
            // System.out.println("val1=" + val1);
            // System.out.println("Val2=" + val2);
            // System.out.println("j=" + j);
            // val2 = num2.pop();
            if (j != 0) {
                int tmpint = val2 + val1 + j;
                cur.val = tmpint % 10;
                j = tmpint / 10;

            } else {
                int tmpint = val2 + val1;
                cur.val = tmpint % 10;
                j = tmpint / 10;
            }
            ListNode tmp = new ListNode();
            cur.next = tmp;
            last = cur;
            cur = tmp;

        }
        if (j != 0) {
            // ListNode tmp = new ListNode(j);
            // cur.next = tmp;
            cur.val = j;
        } else {
            last.next = null;
        }
        return head;
    }
}