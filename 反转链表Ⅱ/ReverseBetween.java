public class ReverseBetween {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev = null;
        ;
        ListNode next = head;
        ListNode preleft = null;
        ListNode nextleft = null;
        ListNode l = null;
        ListNode r = null;
        int cnt = 0;
        // ListNode newleft = null;
        while (next != null) {
            ++cnt;
            if (cnt == left) {
                preleft = prev;
                l = next;

            }
            if (cnt == right) {

                r = next;
                nextleft = r.next;
                r.next = null;
                reverseList(l);
                break;

            }
            prev = next;
            next = next.next;

        }
        if (left == 1) {
            l.next = nextleft;
            return r;

        } else {
            preleft.next = r;
            l.next = nextleft;
            return head;

        }

    }
}