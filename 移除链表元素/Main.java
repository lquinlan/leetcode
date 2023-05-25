public class Main {
    public static void main(String[] args) {

    }
}

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode newNode = new ListNode(-1, head);
        ListNode oldNode = newNode;
        // System.out.println(newNode.next.val);
        while (head != null) {
            if (head.val == val) {
                oldNode.next = head.next;
                head.next = null;
                head = oldNode.next;
                // oldNode=
            } else {
                oldNode = head;
                head = head.next;
            }

        }
        return newNode.next;

    }
}