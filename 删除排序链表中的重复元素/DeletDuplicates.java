public class DeletDuplicates {
    public static void main(String[] args) {

    }
}

// Definition for singly-linked list.
public class ListNode {
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode tmp = head.next;
        current.next = null;

        while (tmp != null) {
            if (tmp.val != current.val) {
                current.next = tmp;
                current = tmp;

                tmp = tmp.next;
                current.next = null;
            } else {
                tmp = tmp.next;
            }
        }
        return head;

    }
}