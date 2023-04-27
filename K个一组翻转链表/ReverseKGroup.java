public class ReverseKGroup {
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

    void print(ListNode head) {
        System.out.println("newhead");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode lastpre = null;
        while (head != null) {
            ListNode last = head;
            boolean f = false;
            for (int i = 0; i < k - 1; ++i) {

                head = head.next;
                if (head == null) {
                    f = true;
                    break;
                }
            }
            if (f) {
                if (prev == null) {
                    prev = head;
                }
                if (lastpre != null) {
                    lastpre.next = last;
                }
                break;
            } else {
                ListNode tmp = head.next;
                head.next = null;
                ListNode newhead = reverseList(last);
                // print(newhead);
                if (prev == null) {
                    prev = newhead;
                }
                head = tmp;
                if (lastpre == null) {
                    lastpre = last;

                } else {
                    // System.out.println("lastpre=="+lastpre.val);
                    // System.out.println("newha="+newhaed.val);
                    lastpre.next = newhead;
                    // System.out.println(lastpre.next.val);
                    lastpre = last;
                }

            }

        }

        return prev;

    }
}