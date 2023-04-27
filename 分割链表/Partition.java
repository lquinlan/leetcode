public class Partition {
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode newNode1 = new ListNode();
        ListNode cur1 = newNode1;
        ListNode newNode2 = new ListNode();
        ListNode cur2 = newNode2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = head;
                head = head.next;
                cur1.next = null;

            } else {
                cur2.next = head;
                cur2 = head;
                head = head.next;
                cur2.next = null;

            }
        }
        cur1.next = newNode2.next;
        newNode2.next = null;
        return newNode1.next;

    }
}