public class IntersectionNode {
    public static void main(String[] args) {

    }
}

class Solution {

    int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode res = null;
        while (lenA < lenB) {
            headB = headB.next;
            --lenB;
        }
        while (lenB < lenA) {
            headA = headA.next;
            --lenA;
        }
        while (headA != null) {
            if (headA == headB) {
                res = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return res;

    }
}

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        next = null;
    }
}