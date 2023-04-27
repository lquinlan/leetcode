public class ReverseList {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    // ListNode prev;

    ListNode(int val) {
        this.val = val;
        // prev = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        // prev = null;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = head;
        if (head == null || head.next == null) {
            return head;
        }
        head = head.next;
        prev.next = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
        return prev;

    }
}