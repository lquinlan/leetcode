public class RotateRight {
    public static void main(String[] args) {

    }
}

// Definition for singly-linked list.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode curhead = head;
        ListNode curend = head;
        int len = 1;
        while (curend.next != null) {
            ++len;
            curend = curend.next;
        }
        if (len == 1) {
            return head;
        }
        curend.next = curhead;
        int off = k % len;
        off = len - off - 1;
        for (int i = 0; i < off; i++) {
            curhead = curhead.next;
        }
        head = curhead.next;
        curhead.next = null;
        return head;

    }
}