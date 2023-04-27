public class DeleteDuplicates {
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode previous = head;
        head = head.next;
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        int cnt = 0;
        while (head != null) {
            if (head.val == previous.val) {
                previous = head;
                head = head.next;
                ++cnt;

            } else if (cnt == 0) {
                cur.next = previous;
                cur = previous;
                cur.next = null;
                previous = head;
                head = head.next;

            } else {
                previous = head;
                head = head.next;
                cnt = 0;

            }
        }
        return newHead.next;

    }
}