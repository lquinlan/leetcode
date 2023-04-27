import org.w3c.dom.ls.LSException;

public class DeletNode {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head;
        ListNode r = head;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < n; ++i) {
            r = r.next;
            ++count;
            if (r == null) {
                flag = true;
                break;
            }
        }
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        if (flag == true) {
            if (n == 1 && count > 1) {
                l.next = null;
            } else {
                head = l.next;
            }
        } else {
            l.next = l.next.next;
        }

        return head;

    }
}