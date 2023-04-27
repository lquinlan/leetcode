public class SwapPair {
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
    public ListNode swapPairs(ListNode head) {
        ListNode pre = null;
        ListNode swap1 = head;
        ListNode swap2 = head.next;
        while (swap1 != null && swap2 != null) {
            ListNode tmp = null;
            if (pre == null) {
                swap1.next = swap2.next;
                swap2.next = swap1;
                head = swap2;

            } else {
                pre.next = swap2;
                swap1.next = swap2.next;
                swap2.next = swap1;

            }
            pre = swap1;
            tmp = swap1;
            swap1 = swap2;
            swap2 = tmp;
            if (swap2.next != null) {
                swap1 = swap1.next.next;
            } else {
                break;
            }
            if (swap1.next != null) {
                swap2 = swap2.next.next;
            } else {
                break;
            }

        }

        return head;

    }
}